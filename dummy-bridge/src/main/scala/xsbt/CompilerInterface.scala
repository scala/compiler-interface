/*
 * Zinc - The incremental compiler for Scala.
 * Copyright Lightbend, Inc. and Mark Harrah
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package xsbt

import xsbti.AnalysisCallback
import scala.tools.sci.{
  APICallback,
  CompilerInterface1,
  Logger,
  OldCallback,
  Problem,
  Reporter,
  VirtualFile
}
import scala.tools.sci.compile._
import scala.tools.nsc.Settings
import scala.collection.mutable
import scala.reflect.io.AbstractFile
import Log.debug
import java.io.File

final class CompilerInterface extends CompilerInterface1 {
  def newCompiler(
      options: Array[String],
      output: Output,
      initialLog: Logger,
      initialDelegate: Reporter
  ): CachedCompiler =
    new CachedCompiler0(options, output, new WeakLog(initialLog, initialDelegate))

  def run(
      sources: Array[VirtualFile],
      changes: DependencyChanges,
      callback: APICallback,
      oldCallback: OldCallback,
      log: Logger,
      delegate: Reporter,
      progress: CompileProgress,
      cached: CachedCompiler
  ): Unit =
    cached.run(sources, changes, callback, oldCallback, log, delegate, progress)
}

class InterfaceCompileFailed(
    val arguments: Array[String],
    val problems: Array[Problem],
    override val toString: String
) extends scala.tools.sci.CompileFailed

class InterfaceCompileCancelled(val arguments: Array[String], override val toString: String)
    extends scala.tools.sci.CompileCancelled

private final class WeakLog(private[this] var log: Logger, private[this] var delegate: Reporter) {
  def apply(message: String): Unit = {
    assert(log ne null, "Stale reference to logger")
    log.error(Message(message))
  }
  def logger: Logger = log
  def reporter: Reporter = delegate
  def clear(): Unit = {
    log = null
    delegate = null
  }
}

private final class CachedCompiler0(args: Array[String], output: Output, initialLog: WeakLog)
    extends CachedCompiler
    with CachedCompilerCompat
    with java.io.Closeable {

  /////////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////// INITIALIZATION CODE ////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////

  val settings = new Settings(s => initialLog(s))
  output match {
    case multi: MultipleOutput =>
      for (out <- multi.getOutputGroups)
        settings.outputDirs
          .add(
            out.getSourceDirectory.toAbsolutePath.toString,
            out.getOutputDirectory.toAbsolutePath.toString
          )
    case single: SingleOutput =>
      val outputFilepath = single.getOutputDirectory.toAbsolutePath
      settings.outputDirs.setSingleOutput(outputFilepath.toString)
  }

  val command = Command(args.toList, settings)
  private[this] val dreporter = DelegatingReporter(settings, initialLog.reporter)
  try {
    if (!noErrors(dreporter)) {
      dreporter.printSummary()
      handleErrors(dreporter, initialLog.logger)
    }
  } finally initialLog.clear()

  /** Instance of the underlying Zinc compiler. */
  val compiler: ZincCompiler = newCompiler(command.settings, dreporter, output)

  /////////////////////////////////////////////////////////////////////////////////////////////////

  def close(): Unit = {
    compiler match {
      case c: java.io.Closeable => c.close()
      case _                    =>
    }
  }

  def noErrors(dreporter: DelegatingReporter) = !dreporter.hasErrors && command.ok

  def commandArguments(sources: Array[File]): Array[String] =
    (command.settings.recreateArgs ++ sources.map(_.getAbsolutePath)).toArray[String]

  import scala.tools.nsc.Properties.versionString
  def infoOnCachedCompiler(compilerId: String): String =
    s"[zinc] Running cached compiler $compilerId for Scala compiler $versionString"

  def run(
      sources: Array[VirtualFile],
      changes: DependencyChanges,
      callback: APICallback,
      oldCallback: OldCallback,
      log: Logger,
      delegate: Reporter,
      progress: CompileProgress
  ): Unit = synchronized {
    debug(log, infoOnCachedCompiler(hashCode().toLong.toHexString))
    val dreporter = DelegatingReporter(settings, delegate)
    try {
      run(
        sources.toList,
        changes,
        callback,
        oldCallback.asInstanceOf[AnalysisCallback],
        log,
        dreporter,
        progress
      )
    } finally {
      dreporter.dropDelegate()
    }
  }

  private def prettyPrintCompilationArguments(args: Array[String]) =
    args.mkString("[zinc] The Scala compiler is invoked with:\n\t", "\n\t", "")
  private val StopInfoError = "Compiler option supplied that disabled Zinc compilation."
  private[this] def run(
      sources: List[VirtualFile],
      changes: DependencyChanges,
      callback: APICallback,
      oldCallback: AnalysisCallback,
      log: Logger,
      underlyingReporter: DelegatingReporter,
      compileProgress: CompileProgress
  ): Unit = {

    if (command.shouldStopWithInfo) {
      underlyingReporter.info(null, command.getInfoMessage(compiler), true)
      throw new InterfaceCompileFailed(args, Array(), StopInfoError)
    }

    if (noErrors(underlyingReporter)) {
      debug(log, prettyPrintCompilationArguments(args))
      compiler.set(callback, oldCallback, underlyingReporter)
      val run = new compiler.ZincRun(compileProgress)

      val wrappedFiles = sources.map(new VirtualFileWrap(_))
      val sortedSourceFiles: List[AbstractFile] =
        wrappedFiles.sortWith(_.underlying.id < _.underlying.id)
      run.compileFiles(sortedSourceFiles)
      processUnreportedWarnings(run)
      underlyingReporter.problems.foreach(p =>
        oldCallback.problem(p.category, p.position, p.message, p.severity, true)
      )
    }

    underlyingReporter.printSummary()
    if (!noErrors(underlyingReporter))
      handleErrors(underlyingReporter, log)

    // the case where we cancelled compilation _after_ some compilation errors got reported
    // will be handled by line above so errors still will be reported properly just potentially not
    // all of them (because we cancelled the compilation)
    if (underlyingReporter.cancelled)
      handleCompilationCancellation(underlyingReporter, log)
  }

  def handleErrors(dreporter: DelegatingReporter, log: Logger): Nothing = {
    debug(log, "Compilation failed (CompilerInterface)")
    throw new InterfaceCompileFailed(args, dreporter.problems, "Compilation failed")
  }

  def handleCompilationCancellation(dreporter: DelegatingReporter, log: Logger): Nothing = {
    assert(dreporter.cancelled, "We should get here only if when compilation got cancelled")
    debug(log, "Compilation cancelled (CompilerInterface)")
    throw new InterfaceCompileCancelled(args, "Compilation has been cancelled")
  }

  def processUnreportedWarnings(run: compiler.Run): Unit = {
    // allConditionalWarnings and the ConditionalWarning class are only in 2.10+
    final class CondWarnCompat(
        val what: String,
        val warnings: mutable.ListBuffer[(compiler.Position, String)]
    )
    implicit def compat(run: AnyRef): Compat = new Compat
    final class Compat { def allConditionalWarnings = List[CondWarnCompat]() }

    val warnings = run.allConditionalWarnings
    if (warnings.nonEmpty)
      compiler.logUnreportedWarnings(warnings.map(cw => ("" /*cw.what*/, cw.warnings.toList)))
  }
}

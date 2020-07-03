package testpkg

import verify._
import java.nio.file.{ Path, Paths }
import sbt.io.IO
import sbt.io.syntax._
import xsbti.{ APICallback, VirtualFile, VirtualFileRef }
import xsbti.compile.{ CompileProgress, DependencyChanges }

trait CompilationTest {

  def compile(vs: Vector[VirtualFile], callback: APICallback, tempDir: File): Unit = {
    val targetDir = tempDir / "target" / "classes"
    IO.createDirectory(targetDir)
    val output = new ConcreteSingleOutput(targetDir.toPath)
    val log = TestConsoleLogger()
    val reporter = new CollectingReporter
    val oldCallback = new TestCallback
    val bridge = ReflectionUtil.bridgeInstance("xsbt.CompilerInterface")
    bridge match {
      case intf: xsbti.CompilerInterface1 =>
        val scalaLibraryJar = ReflectionUtil.scalaLibraryJar
        val cachedCompiler =
          intf.newCompiler(Array("-classpath", scalaLibraryJar.toString), output, log, reporter)
        cachedCompiler.run(
          vs.toArray,
          emptyChanges,
          callback,
          oldCallback,
          log,
          reporter,
          ignoreProgress
        )
    }
  }

  val emptyChanges: DependencyChanges = new DependencyChanges {
    override val modifiedLibraries = new Array[VirtualFileRef](0)
    override val modifiedClasses = new Array[String](0)
    override def isEmpty = true
  }

  val ignoreProgress: CompileProgress = new CompileProgress {
    def startUnit(phase: String, unitPath: String): Unit = ()
    def advance(current: Int, total: Int) = true
  }
}

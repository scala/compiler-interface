package testpkg

import verify._
import java.nio.file.{ Path, Paths }
import sbt.io.IO
import sbt.io.syntax._
import scala.tools.sci.{ VirtualFile, VirtualFileRef }
import scala.tools.sci.compile.{ CompileProgress, DependencyChanges }

object CompilerInterfaceTest extends BasicTestSuite {

  test("CompilerInterface1") {
    IO.withTemporaryDirectory { tempDir =>
      val targetDir = tempDir / "target" / "classes"
      IO.createDirectory(targetDir)
      val output = new ConcreteSingleOutput(targetDir.toPath)
      val log = TestConsoleLogger()
      val reporter = new CollectingReporter
      val callback = new TestCallback
      val vFile: VirtualFile =
        StringVirtualFile("src/A.scala", """package example

object A {
  val x = 1
}
""")
      val vs = Vector(vFile)
      val bridge = ReflectionUtil.bridgeInstance("xsbt.CompilerInterface")
      bridge match {
        case intf: scala.tools.sci.CompilerInterface1 =>
          val scalaLibraryJar = ReflectionUtil.scalaLibraryJar
          val cachedCompiler =
            intf.newCompiler(Array("-classpath", scalaLibraryJar.toString), output, log, reporter)
          cachedCompiler.run(vs.toArray, emptyChanges, callback, log, reporter, ignoreProgress)
          assert((targetDir / "example" / "A.class").exists)
          assert((targetDir / "example" / "A$.class").exists)
      }
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

final class ConcreteSingleOutput(val getOutputDirectory: Path)
    extends scala.tools.sci.compile.SingleOutput {
  override def toString: String = s"SingleOutput($getOutputDirectory)"
}

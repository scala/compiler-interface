package testpkg

import verify._
import sbt.io.IO
import sbt.io.syntax._

object APICallbackTest extends BasicTestSuite with CompilationTest {
  test("APICallbackTest1") {
    IO.withTemporaryDirectory { tempDir =>
      val callback = new TestAPICallback
      compile(Vector(StringVirtualFile("src/A.scala", """package example

object HelloWorld {
  final val msg = "Hello, World!"
}
""")), callback, tempDir)
      assert(callback.apis.nonEmpty)
    }
  }
}

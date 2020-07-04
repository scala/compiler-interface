package testpkg

import verify._
import sbt.io.IO
import sbt.io.syntax._
import APIEvent._

object APICallbackTest extends BasicTestSuite with CompilationTest {
  test("APICallbackTest1") {
    IO.withTemporaryDirectory { tempDir =>
      val callback = new TestAPICallback
      val src = StringVirtualFile("src/A.scala", """package example

class HelloWorld {
  final val msg = "Hello, World!"
}
""")
      compile(Vector(src), callback, tempDir)
      assert(callback.apis.nonEmpty)
      assert(
        callback.events == List(
          StartSource(src),
          StartClassLike(1, "example.HelloWorld", true),
          EndClassLike,
          EndSource,
        )
      )
    }
  }
}

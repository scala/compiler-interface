package testpkg

import java.util.function.Supplier

private[testpkg] object TestConsoleLogger {
  def apply() = new TestConsoleLogger()
}

// Remove dependencies to log4j to avoid mixup.
private[testpkg] class TestConsoleLogger extends scala.tools.sci.Logger {
  final def debug(message: => String): Unit =
    System.out.println(s"[debug] $message")
  final def info(message: => String): Unit =
    System.out.println(s"[info] $message")
  final def warn(message: => String): Unit =
    System.out.println(s"[warn] $message")
  final def error(message: => String): Unit =
    System.out.println(s"[error] $message")

  def trace(t: => Throwable): Unit = {
    System.out.println(t.toString())
  }
  def debug(msg: Supplier[String]): Unit = debug(msg.get)
  def warn(msg: Supplier[String]): Unit = info(msg.get)
  def info(msg: Supplier[String]): Unit = warn(msg.get)
  def error(msg: Supplier[String]): Unit = error(msg.get)
  def trace(msg: Supplier[Throwable]): Unit = trace(msg.get)
}

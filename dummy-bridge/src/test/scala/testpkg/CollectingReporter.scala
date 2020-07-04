package testpkg

import scala.tools.sci.{ Position, Severity }

class CollectingReporter extends scala.tools.sci.Reporter {
  val buffer = collection.mutable.ArrayBuffer.empty[scala.tools.sci.Problem]

  def reset(): Unit = {
    // System.err.println(s"DEBUGME: Clearing errors: $buffer")
    buffer.clear()
  }
  def hasErrors: Boolean = buffer.exists(_.severity == Severity.Error)
  def hasWarnings: Boolean = buffer.exists(_.severity == Severity.Warn)
  def printSummary(): Unit = ()
  def problems: Array[scala.tools.sci.Problem] = buffer.toArray

  def log(problem: scala.tools.sci.Problem): Unit =
    log(problem.position, problem.message, problem.severity)

  /** Logs a message. */
  def log(pos: scala.tools.sci.Position, msg: String, sev: scala.tools.sci.Severity): Unit = {
    object MyProblem extends scala.tools.sci.Problem {
      def category: String = null
      def severity: Severity = sev
      def message: String = msg
      def position: Position = pos
      override def toString = s"$position:$severity: $message"
    }
    System.err.println(s"Logging: $MyProblem")
    buffer.append(MyProblem)
  }

  /** Reports a comment. */
  def comment(pos: scala.tools.sci.Position, msg: String): Unit = ()

  override def toString = "CollectingReporter"
}

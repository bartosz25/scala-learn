package com.waitingforcode.caseclass

import scala.collection.mutable.ListBuffer

/**
  * This code illustrates the example of {@code case class}. They are characterized by:
  * - constructor parameters are exported (publicly accessible)
  * - should depend only on constructor arguments
  * - is immutable - constructor arguments are prefixed with *val* by the compiler
  * - is defined with *case* keyword
  * - is not a simple data structure but also is used for structural matching of data
  * - can be created without *new* keyword, e.g. as MyCaseClass(param1, param2)
  * - has equals, hashCode and toString methods automatically generated
  *
  *
  * http://stackoverflow.com/questions/2312881/what-is-the-difference-between-scalas-case-class-and-class
  * https://www.scala-lang.org/old/node/107.html
  * http://www.alessandrolacava.com/blog/scala-case-classes-in-depth/
  */
abstract class LogEntry
case class TraceLogEntry(message: String, loggingTimestamp: Long) extends LogEntry
case class ErrorLogEntry(error: Exception, loggingTimestamp: Long) extends LogEntry

// companion object holding all log messages
object LogEntry {
  val entries = new ListBuffer[LogEntry]()
}

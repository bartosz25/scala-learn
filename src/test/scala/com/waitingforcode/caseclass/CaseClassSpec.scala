package com.waitingforcode.caseclass

import org.scalatest.{FlatSpec, Matchers}

class CaseClassSpec extends FlatSpec with Matchers {

  "Trace log entry " should " be logged with appropriated format" in {
    LogEntry.entries += new TraceLogEntry("Error message", 123L)

    val lastEntry = LogEntry.entries.last

    lastEntry shouldBe a [TraceLogEntry]
  }

  "Error log entry " should " be logged with exception information" in {
    val runtimeError = new RuntimeException("error !")
    LogEntry.entries += new ErrorLogEntry(runtimeError, 456L)

    val lastEntry = LogEntry.entries.last

    lastEntry shouldBe a [ErrorLogEntry]
    val errorLogEntry = lastEntry.asInstanceOf[ErrorLogEntry]
    errorLogEntry.error.getMessage shouldEqual "error !"
  }

  /**
    * This test illustrates the use of {@code pattern matching} and {@code case class}es.
    *
    * As you can see, case class allows to make specific matching very easily. It's visible in the case of TraceLogEntry
    * which generates 2 different outputs according to timestamp value.
    */
  "Log entry " should " be correctly handled with pattern matching" in {
    LogEntry.entries += new TraceLogEntry("Error message", 123L)

    def converter(logEntry: LogEntry): String = logEntry match {
      case ErrorLogEntry(_, _) =>
        "ERROR"
      case TraceLogEntry(_, 123L) =>
        "PAST_TRACE"
      case TraceLogEntry(_, 345L) =>
        "CURRENT_TRACE"
    }

    var logLabel:String = "x"
    for (entry <- LogEntry.entries) {
      logLabel = converter(entry)
      println("Log is: " + entry)
    }
    logLabel shouldEqual("PAST_TRACE")
  }



}

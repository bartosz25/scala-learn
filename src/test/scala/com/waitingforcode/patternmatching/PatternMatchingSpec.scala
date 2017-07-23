package com.waitingforcode.patternmatching

import org.scalatest.{FlatSpec, Matchers}

class PatternMatchingSpec extends FlatSpec with Matchers {

  "Number " should " be correctly matched through pattern matching" in {
    val age = 39

    val ageLabel = age match {
      case young if age < 20 => "young"
      case old if age >= 20 => "old"
    }

    ageLabel shouldEqual "old"
  }

}

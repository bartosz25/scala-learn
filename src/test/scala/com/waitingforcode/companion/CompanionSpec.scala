package com.waitingforcode.companion

// Aliasing only for learning purposes
import org.scalatest.{FlatSpec => UsedTestSpec, Matchers}

class CompanionSpec extends UsedTestSpec with Matchers {

  "Player " should " be able to call companion  method" in {
    val couple : Couple = new Couple("Bobs");
    couple.seniority = 10;
    println("Seniority is " + couple.seniority)

    Couple.isACouple(2) should be (true)
    couple.seniority should equal (10)
  }

}

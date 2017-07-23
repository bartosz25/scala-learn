package com.waitingforcode.guard

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ListBuffer

/**
  * *Guards* are specific instructions involved into matching {@code case}s or {@code for} loops, allowing
  * more fine-grained control on data.
  */
class GuardSpec extends FlatSpec with Matchers {

  "A guard " should " only allow to match numbers lower than 10" in {
    val numbers = List(3, 5, 12, 21, 35, 39)

    def scale(number:Int):Int = {
      number match {
        case nr if 0 to 9 contains nr => 9
        case nr if 10 to 100  contains nr => 99
        case _ => 1999999
      }
    }

    val scaledNumber9 = scale(9)

    scaledNumber9 shouldBe 9
  }

  "A guard " should " control iteration only on pair numbers" in {
    val numbers = List(4, 6, 7, 8, 9, 10)

    val pairNumbers = new ListBuffer[Int]
    for(number <- numbers.iterator; if (number % 2 == 0)) {
      pairNumbers += number
    }

    pairNumbers should contain theSameElementsAs List(4, 6, 8, 10)
  }

}

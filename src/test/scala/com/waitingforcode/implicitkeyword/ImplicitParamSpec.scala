package com.waitingforcode.implicitkeyword

import org.scalatest.{FlatSpec, Matchers}

class ImplicitParamSpec extends FlatSpec with Matchers {

  "implicit parameters" should "be passed in method" in {
    implicit val multiplier = 2

    // TODO : implement me
    //
    //
    //
    //
    def multiplyNumber(number: Int)(implicit multiplier: Int): Int = {
      number * multiplier
    }

    val result = multiplyNumber(10)

    result shouldEqual(20)
  }

}

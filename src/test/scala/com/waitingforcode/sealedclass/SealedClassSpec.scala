package com.waitingforcode.sealedclass

import org.scalatest.{FlatSpec, Matchers}

class SealedClassSpec extends FlatSpec with Matchers {

  "Compiler " should " show the warning about not exhaustive pattern matching" in {
    def isFrontLanguage(language: ProgrammingLanguage):Boolean = {
      language match {
        case Html() => true
      }
    }
    // At compilation above pattern matching, since it doesn't handle Java and C++ cases,
    // the compilator should show a warning similar to the following one:
    // Warning:(9, 7) match may not be exhaustive.
    // It would fail on the following inputs: CPlusPlus(), Java()
    // language match {
    // ^
    val htmlIsFront = isFrontLanguage(new Html())

    htmlIsFront shouldBe true
  }

  "Compile " should " not show a warning since sealed class pattern matching is exhaustive" in {
    def isFrontLanguage(language: ProgrammingLanguage):Boolean = {
      language match {
        case Html() => true
        case Java() | CPlusPlus() => false
      }
    }

    val javaIsFront = isFrontLanguage(new Java())

    javaIsFront shouldBe false
  }

}

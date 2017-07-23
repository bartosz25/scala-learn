package com.waitingforcode.implicitkeyword

import org.scalatest.{FlatSpec, Matchers}

class ImplicitConversionSpec extends FlatSpec with Matchers {

  "implicit conversion" should "be correctly done" in {
    case class Sentence (sentence: String) {
      def skipNotMeaningfulWords(): String = {
        sentence.split(" ")
          .filter(_.length > 2)
          .mkString(" ")
      }
    }

    case class LongSentence (sentence: String) {
      def skipNotMeaningfulWords(): String = {
        sentence.split(" ")
          .filter(_.length > 5)
          .mkString(" ")
      }
    }

    case class Words (words: Seq[String])

    // Implicit method converting Words object, not supporting skipNotMeaningfulWords(),
    // to Sentence that does support this method
    // Scala compiler, when .skipNotMeaningfulWords() on Words instance is called,
    // will look for method defined as implicit, able to convert Words to something
    // supporting skipNotMeaningfulWords
    // We also added another class, ExigentSentence that filter on words longer than 5 characters.
    // However, the method of this object won't be called since
    // there are no implicit conversion defined
    implicit def convertWordsToSentence(words: Words): Sentence = {
      Sentence(words.words.mkString(" "))
    }

    val words = Words(Seq("Sir", "Reginald", "wrote", "The", "Chairman's", "Handbook",
      "The", "House", "of", "Commons", ":", "Illustrations",  "of",  "its",  "History", "and",
      "Practice", "(", "London", ",", "1869", ")", ";", "and", "Cromwell", ":", "an",  "appreciation",
      "based", "on", "contemporary", "evidence", "(", "London", ",", "1890", ")"))

    val notMeaningfulWords = words.skipNotMeaningfulWords()

    notMeaningfulWords shouldEqual("Sir Reginald wrote The Chairman's Handbook The House Commons Illustrations its " +
      "History and Practice London 1869 and Cromwell appreciation based contemporary evidence London 1890")
  }


}

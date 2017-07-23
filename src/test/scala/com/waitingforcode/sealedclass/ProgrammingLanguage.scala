package com.waitingforcode.sealedclass

/**
  * *Sealed* keywords defines a class that all children must be declared inside the same source file.
  * The goal is to help compiler to control exhaustivity of {@code pattern matching} controls.
  * In below example we can find 3 classes extending ProgrammingLanguage sealed class. Now, if the pattern matching
  * constructed with only 2 of them is compiled, the compiler will show a warning like:
  * "Warning:(9, 7) match may not be exhaustive. It would fail on the following inputs: MissingClass1, MissingClass2..."
  *
  * http://www.scala-lang.org/old/node/123
  * http://stackoverflow.com/questions/32199989/what-are-the-differences-between-final-class-and-sealed-class-in-scala
  * http://underscore.io/blog/posts/2015/06/02/everything-about-sealed.html
  */
sealed abstract class ProgrammingLanguage

case class Java() extends ProgrammingLanguage
case class CPlusPlus() extends ProgrammingLanguage
case class Html() extends ProgrammingLanguage


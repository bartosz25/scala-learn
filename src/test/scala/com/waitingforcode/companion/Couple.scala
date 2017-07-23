package com.waitingforcode.companion

/**
  * Below code is an example of Scala's {@code Companion Object} (CO). But before understanding this concept,
  * it's important to understand the idea of {@code Singleton}. According to official Scala documentation, a Singleton
  * is an object having only static members (ie. members not belonging to specific class instance). THe Singleton is
  * distinguishable from instance classes because it uses the keyword {@code object} and not {@code class} when it's
  * declared.
  *
  * Notes applicable for COs:
  * - must be defined in the same file
  * - visibility: even if something is declared private in CO, Companion Class can access it and vice versa
  * - even traits can have
  * - members accessible without class instance should go to the CO
  *
  * When comparing with Java world, CO is like a classical *Util final class, having only static methods and private
  * constructor. [!] Scala doesn't support *static* keyword.
  *
  * Below Couple class is a Companion Class of the Couple Object.
  */
class Couple(argFamilyName : String) {

  val familyName = argFamilyName

  private var _seniority : Int = -1;

  def seniority = _seniority

  def this(argFamilyName: String, seniority: Int) = {
    this(argFamilyName)
    _seniority = seniority
  }

  // Unit === void
  def seniority_=(value:Int):Unit = {
    println(s"Setting seniority to $value")
    _seniority = value
  }


}

/**
  * This is the Companion Object of Couple class.
  */
object Couple {

  def isACouple(numberOfPeople : Int) : Boolean = {
    if (numberOfPeople == 2) {
      return true;
    }
    return false;
  }

}

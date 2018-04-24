package FUNCTIONS.`implicit`


  object Implicit_01 extends App {

    case class MyString(s: String) {
      def whose = s"I'm yours :] $s"
    }

    implicit def strToMyString(x: String): MyString = MyString(x)

    println("heh".whose)
  }




//object Implicit_02 extends App {
//}

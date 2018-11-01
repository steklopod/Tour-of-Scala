package implicits


object Implicit_01 extends App {
  implicit def strToMyString(x: String): MyString = MyString(x)

  case class MyString(s: String) {
    def whose = s"I'm yours :] $s"
  }

  println("heh".whose)
}

//2///////////

object Squaring {
  implicit class Squarer(x: Int) {
    def numberSquaring[A](f: => A): Unit = {
      println(x + " * " + x + " = " + x * x);
    }
  }
}

object SquaringDemo extends App {
  import implicits.Squaring._

    100 numberSquaring()
}


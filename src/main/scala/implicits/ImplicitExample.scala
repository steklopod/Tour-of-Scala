package implicits

object ImplicitExample extends App {
  implicit def strToMyString(x: String): MyString = MyString(x)

  println("heh".whose)
}

case class MyString(s: String) {
  def whose = s"I'm yours :] $s"
}


//2-й пример - implicit class
object SquaringDemo extends App {
  implicit class Squarer(x: Int) {
    def numberSquaring[A](f: => A): Unit = {
      println(x + " * " + x + " = " + x * x);
    }
  }


  100 numberSquaring ()
}

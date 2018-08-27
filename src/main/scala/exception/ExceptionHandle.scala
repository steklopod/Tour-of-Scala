package exception

class ExceptionHandle {
  val x = try {
    Integer.parseInt("10")
  } catch {
    case ex: Exception => 0
    case _: IllegalArgumentException => println("Got some other kind of exception")
  }

}

//2 пример//////////////////////////
object PartialFunctionClass extends App {

  def handler: PartialFunction[Throwable, Any] = {
    case iae: IllegalArgumentException =>
      System.out.println("Отловлено IllegalArgumentException")
    case ex: RuntimeException =>
      System.out.println("Отловлено  RuntimeException с сообщением: " + ex.getMessage)
  }

  try {
    val x = 0
    throw new RuntimeException("поймай меня, если сможешь")
  }
  catch handler
}

//3 пример//////////////////////////
object ExceptionEx_02 extends App {

  import scala.util.control.Exception._

  def assertPositive(x: Int): Int =
    if (x >= 0) x else throw new IllegalArgumentException(s"$x is negative")

  println(
    catching(classOf[IllegalArgumentException]) opt assertPositive(1)
  ) //Some(1)

  println(
    catching(classOf[IllegalArgumentException]) opt assertPositive(-1)
  ) //None

}
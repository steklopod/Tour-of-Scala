package exception

class ExceptionHandle {
  val x = try {
    Integer.parseInt("10")
  } catch {
    case ex: Exception => 0
    case _: IllegalArgumentException => println("Got some other kind of exception")
  }

}

object PartialFunctionClass extends App {
  def handler: PartialFunction[Throwable, Any] = {
    case iae: IllegalArgumentException =>
      System.out.println("Got iae")
    case ex: RuntimeException =>
      System.out.println("Got ex " + ex.getMessage)
  }

  try {
    val x = 0
    throw new RuntimeException
  } catch handler
}


object ExceptionEx_02 extends App {

  import scala.util.control.Exception._

  def assertPos(x: Int): Int =
    if (x >= 0) x else throw new IllegalArgumentException(s"$x is negative")

  println(
    catching(classOf[IllegalArgumentException]) opt assertPos(1)
  ) //Some(1)

  println(
    catching(classOf[IllegalArgumentException]) opt assertPos(-1)
  ) //None

}
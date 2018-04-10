package FUNCTIONS

class ExceptionHandle {
  val x = try {
    Integer.parseInt("10")
  } catch {
    case ex: Exception => 0
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
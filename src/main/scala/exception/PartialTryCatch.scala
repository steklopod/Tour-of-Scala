package exception

object PartialTryCatch extends App{

  def handleIae: PartialFunction[Throwable, Any] = {
    case iae: ArithmeticException => System.out.println("Got ArithmeticException")
  }
  def handleNpe: PartialFunction[Throwable, Any] = {
    case iae: NullPointerException => println("Got npe")
  }
  try{
    println(1/0)
  }
  catch handleIae.orElse(handleNpe)
}

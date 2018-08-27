package OOP.classes

// sealed говорит о том, что наследники могут  быть назначены только в этом же классе
sealed trait RunOne{ def run(): Unit = println("Run")}

trait RunTwo       { def run(): Unit = println("Run, Forest!")}

class GoodRunner extends RunOne with RunTwo {
  override def run() = println("Ты не можешь бежать т.к. я переопределил эту функцию :-)")
}

object GoodRunnerTest extends App {
  println(new GoodRunner().run())
}
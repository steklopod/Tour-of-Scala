package practic

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.io.Source

class ThreadApp2 {

}

object ThreadApp2 extends App {
  def spawn(command: String): Future[String] = Future {
    val process = sys.runtime.exec(command)
    Source.fromInputStream(process.getInputStream).getLines().toString().mkString(", ")
  }

  val result = Await.result(spawn("Ping ya.ru -t 2"), Duration.Inf)
  println(result)
}

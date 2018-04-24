package FUNCTIONS

object Fibonachi extends App {

  val fibs: Stream[Int] =
    0 #:: 1 #:: (fibs zip fibs.tail)
      .map { t => t._1 + t._2 }

  fibs.take(20).print(" ")

  // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 empty

}

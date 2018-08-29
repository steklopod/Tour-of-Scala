package collections

object ForComprehension extends App {

  val names = Array("Dima", "Kolya", "Vasya")

  // 1
  for (n <- names) println("NAME: " + n + "\n")

  // 2
  0 until 10 foreach(a => println(a))

  // 3
  val capNames = for( e <- names) yield e.capitalize //увеличиваем первую букву каждого слова
  capNames.foreach(println(_))

  // 4
  val length = for ( e <- names) yield e.length
  length.foreach(println(_))
}

object ForComprehension_2 extends App {
  case class User(name: String, age: Int)

  val userBase = List(
    User("Вася", 28),
    User("Kelly", 33),
    User("Jennifer", 44),
    User("Дима", 23)
    )

  val twentySomethings = for (user <- userBase if user.age >=20 && user.age < 30) yield user.name  // т.е. добавить в список

  twentySomethings.foreach(name => println(name))  //  Вася Дима
}

object ForComprehension_3 extends App {
  def foo(n: Int, v: Int) =
    for (i <- 0 until n;
         j <- i until n if i + j == v)
      yield (i, j)

  foo(10, 10) foreach { case (i, j) => println(s"($i, $j) ")  }  // (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)


  def fooWithPrint(n: Int, v: Int) =
    for (i <- 0 until n;
         j <- i until n if i + j == v)
      println(s"($i, $j)")

  fooWithPrint(10, 10)
}
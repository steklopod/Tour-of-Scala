package OOP.null_nill_nothing

object NullExample extends App {
  // Null работает только для ссылочных типов, для более общего случая, есть ничто (Nothing).
  var x = "String"
  var i = List(1)

  x = null
  i = null

  println(s"x = $x \n i = $i")
}

object NothingExample extends App {

  def error(message: String): Nothing = throw new RuntimeException(message)
}

object UnitExample extends App {
  //class Unit extends Any with AnyVal
  //Внимание! AnyVal, а не AnyRef. Это значит, что Unit это не ссылочный тип (в отличие от Null).

  val u = ()

  def foo(): Unit = {}
}

object NilExample extends App {
  //  Nil – объект, пустой список (extends List[Nothing]).
  // аналогично - (Nil.::(2)).::(1)
  var x = 1 :: 2 :: Nil
}

object NoneExample extends App {
  //None – это такой хитрый объект (extends Option[Nothing]), который используется в случае, если мы хотим
  // получить что-то, например, из Map, а его там нет.
  var m = Map(1->2)
  val n = m.get(100)// ну нет такого элемента

  //n: Option[Int] = None
}

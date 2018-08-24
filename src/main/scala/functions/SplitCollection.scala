package functions

/**
  * Примеры разбиения коллекции при помощи функций groupBy, split, partition, sliding, unzip
  */
object GroupBy {
  val donuts: Seq[String] = Seq("Обычный пончик", "Клубничный пончик", "Глазурованный пончик")
  val donuts2: Seq[Donut] = Seq(Donut("Обычный пончик", 1.5), Donut("Клубничный пончик", 2.0), Donut("Глазурованный пончик", 2.5))

  def donutsGroup:  Map[Char, Seq[String]]  = donuts.groupBy(_.charAt(0))
  def donutsGroup2: Map[String, Seq[Donut]] = donuts2.groupBy(_.name)
}

case class Donut(name: String, price: Double)

object GroupByExample extends App {
  import functions.GroupBy._

    println(s"   Список пончиков до группировки: $donuts")
    println(s"\n Группировка по первой букве имени пончика:         \n $donutsGroup")
    println(s"\n Группировка объектов типа Donut, по имени пончика: \n  $donutsGroup2")
    println(s"\n Группировка объектов типа Donut, по имени пончика: \n  $donutsGroup2")
}


////////////////////////////////////
object SplitCollection extends App {
  private[this] val x = List(15, 10, 5, 8, 20, 12)

  val split: (List[Int], List[Int]) = x.splitAt(2)
    println(s"\n splitAt 2: $split")

  //GroupBy принимает предикатную функцию и использует ее для группировки элементов по ключевым словам и значениям в коллекцию Map.
  val greaterThen10: Map[Boolean, List[Int]] = x.groupBy(_ > 10)
    println(s"\n greaterThen10: $greaterThen10")

  val truesOnly = greaterThen10(true)
    println(s"greaterThen10 (only true): $truesOnly")

  //PARTITION разбивает коллекцию на 2 части согласное переданному предикату:
  val (greater, less): (List[Int], List[Int]) = x.partition(_ > 10)
    println(s"\n GREATER, LESS: greater than 10: $greater , less than 10: $less")

  //SPAN возвращает Tuple2 на основе предиката p, состоящего из
  // «самого длинного префикса этого списка, чьи элементы все удовлетворяют p, и остальной части этого списка».
  val span20: (List[Int], List[Int]) = x.span(_ < 20)
    println(s"\n span20: $span20")
}

/**
  * Как показано, скользящие работы проходят мимо «скользящего окна» над исходной последовательностью,
  * возвращая последовательности длины, заданной размером. Параметр `step` позволяет пропустить элементы, как показано
  * в последних двух примерах. Первые два примера являются наиболее полезными, сначала с размером шага по умолчанию 1,
  * а затем, когда шаг соответствует размеру.
  */
object Sliding extends App {
  // size = 2
  val nums = (1 to 5).toArray

  nums.sliding(2).toList     //List[Array[Int]] = List(Array(1, 2), Array(2, 3), Array(3, 4), Array(4, 5))

  // size = 2, step = 2
  nums.sliding(2, 2).toList  //List[Array[Int]] = List(Array(1, 2), Array(3, 4), Array(5))

  // size = 2, step = 3
  nums.sliding(2, 3).toList  // List[Array[Int]] = List(Array(1, 2), Array(4, 5))
}

/**
  * Метод распаковки  можно использовать для получения последовательности значений Tuple2 и создания двух результирующих списков:
  * одного, который содержит первый элемент каждого кортежа,
  * а другой, который содержит второй элемент из каждого кортежа:
  */
object Unzip extends App {
  val listOfTuple2s = List((1, 2), ('a', 'b'))

  val x = listOfTuple2s.unzip
    println(s"listOfTuple2s.unzip: $x") //(List(1, a),List(2, b))

  //UNZIP учитывая список пар, можно разархивировать список, чтобы создать список женщин и список мужчин:
  val couples = List(("Смирнова", "Колтович"), ("Катя", "Дима"))
  val (women, men ) = couples.unzip
    println(s"men: $men , women:  $women")

  //ZIP
  val wom = List("Смирнова", "Катя")
  val m   = List("Колтович", "Дима")
  val couplesZ = wom zip m
    println(s"couplesZ: $couplesZ")
}
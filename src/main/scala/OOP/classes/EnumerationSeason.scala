package OOP.classes

object Season extends Enumeration {
  val Winter, Spring, Summer,
  Autumn = Value
}

object EnumTest extends App {
  //  val applyT = Season.apply(x: Int)

  val vals = Season.values
  println(vals)

  val maxId = Season.maxId
  println(maxId)

  val id = Season.Winter.id
  println(id)

  println(Season.Winter + Season.Autumn)
  println(Season.Winter < Season.Autumn)
}

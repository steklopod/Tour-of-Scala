package partial

object PartialApplied extends App {

  val sample = 1 to 10
  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x + " четное число"
  }

  // метод `collect` может использовать `isDefinedAt`, чтобы выбрать, какие члены собирать
  val evenNumbers = sample collect isEven

  val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x + " нечетное"
  }

  // метод `orElse` позволяет связать другую частичную функцию для обработки
  // ввод за пределами объявленного домена
  val numbers = sample map (isEven orElse isOdd)

  numbers foreach println
}

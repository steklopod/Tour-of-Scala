package extractor

import scala.util.Random

object CustomerID {

  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head)
    else None
  }
}

object ExtraxctorTest extends App {
  val customer1ID = CustomerID("Дима") // Дима--23098234908

  customer1ID match {
    case CustomerID(name) => println(name) // prints Дима
    case _                => println("Не могу найти CustomerID")
  }

  val customer2ID      = CustomerID("Вася")
  val CustomerID(name) = customer2ID
  println(name) //  Вася

  val CustomerID(name2) = "--asdfasdfasdf"

//  val CustomerID(name3) = "-asdfasdfasdf"   // Если совпадений не найдено, будет брошено `scala.MatchError`

}

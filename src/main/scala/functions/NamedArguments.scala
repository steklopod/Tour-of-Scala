package functions

object NamedArguments extends App {
  def printName(firstName: String = "Неизвестен", lastName: String = "Неизвестен") {
    System.out.format("Your name is %s %s\n", firstName, lastName)
  }

  printName(firstName = "Alvin", lastName = "Alexander")

  printName(firstName = "Вася")
}
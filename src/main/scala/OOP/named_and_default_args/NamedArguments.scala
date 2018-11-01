package OOP.named_and_default_args

object NamedArguments extends App {

  def printName(firstName: String, lastName: String) {
    System.out.format("Ваше имя и фамилия:%s %s\n", firstName, lastName)
  }


  //1-ый вариант с перестановкой параметров
  printName( lastName = "Дима", firstName = "Колтович" )

  //2-вариант (классический)
  printName("Колтович", "Дима")
}



object DefaultArguments extends App {
  def printName(firstName: String = "Неизвестен", lastName: String = "Неизвестен") {
    System.out.format("Ваше имя и фамилия: %s %s\n", firstName, lastName)
  }

  printName("Колтович", "Дима")
  printName("Колтович")
  printName()
}



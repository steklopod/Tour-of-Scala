package OOP.constructor

class Person(val имя: String, val фамилия: String, val возраст: Int) {

  def this(имя: String) {
    this(имя, "", 0)
      println("\n Фамилия и возраст неизвестны.")
  }

  def this(имя: String, фамилия: String) {
    this(имя, фамилия, 0)
      println("\n Возраст неизвестен.")
  }

  override def toString: String = "%s %s, возраст: %d".format(имя, фамилия, возраст)
}

object MultipleConstructor extends App {

    val всеАргументы = new Person("Дима", "Колтович", 20)
      println(всеАргументы)

    val коля = new Person("Коля", "Воронкович")
      println(коля)

    val вася = new Person("Вася")
      println(вася)
}



package companion

object Companion {

  class Person(val firstName: String, val middleName: String, val lastName: String) {
    override def toString = s"Person($firstName, $middleName, $lastName)"
  }
  object Person {
    def apply(firstName: String, lastName: String) = new Person(firstName, "", lastName)
    def apply(firstName: String)                   = new Person(firstName, "", "")
  }

}

object PersonTest extends App{
  import companion.Companion.Person

  val p = Person("Дима", "Колтович")
  println(p)
}

//2 пример//////////////////////////





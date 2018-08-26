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

abstract class AnimalCounter {
  var animals = 0
  def name: String
  def count() {
    animals += 1
    println("%d %ss created so far".format(animals, name))
  }
}

abstract class Animal {
  def companion: AnimalCounter
  companion.count()
}

class  Dog extends Animal { def companion = Dog }
object Dog extends AnimalCounter {
  val name = "dog"
}

class  Cat extends Animal { def companion = Cat }
object Cat extends AnimalCounter {
  val name = "cat"
}

object AnimalTest extends App{
  new Dog
  new Cat
  new Cat
}



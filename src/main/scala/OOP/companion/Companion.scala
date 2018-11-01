package OOP.companion
import OOP.companion.Companion.Person

object Companion {

  class Person(val firstName: String, val middleName: String, val lastName: String) {
    override def toString = s"Person($firstName, $middleName, $lastName)"
  }
  object Person {
    def apply(firstName: String, lastName: String) = new Person(firstName, "", lastName)
    def apply(firstName: String)                   = new Person(firstName, "", "")
  }

}

object PersonTest extends App {
  val p = Person("Дима", "Колтович")
  println(p)
}

//2 пример
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

class Dog extends Animal { def companion = Dog }
object Dog extends AnimalCounter {
  val name = "dog"
}

class Cat extends Animal { def companion = Cat }
object Cat extends AnimalCounter {
  val name = "cat"
}

object AnimalTest extends App {
  new Dog
  new Cat
  new Cat
}

//3 пример
class Pizza(var crustType: String) {
  override def toString = "тип теста: " + crustType
}
object Pizza {
  val CRUST_TYPE_THIN  = "тонкая"
  val CRUST_TYPE_THICK = "толстая"
  def getFoo           = "Foo"
}

object PizzaTest extends App {
  println(Pizza.CRUST_TYPE_THIN)
  println(Pizza.getFoo)

  var p = new Pizza(Pizza.CRUST_TYPE_THICK)
  println(p)
}

//3.1 пример
// Доступ к частным членам
class Foo {
  private val secret = 2
}

object Foo {
  // доступ к приватному полю класса 'secret'
  def double(foo: Foo) = foo.secret * 2
}

object Driver extends App {
  val f = new Foo
  println(Foo.double(f)) // prints 4
}

//3.2 пример
object SomeS {

  class Foo2 {
    // доступ к приватному полю объекта 'obj'
    def printObj {
      println(s"I can see ${Foo2.obj}")
    }
  }
  object Foo2 {
    private val obj = "Foo2's object"
  }
}

object SomeSTest extends App {
  import OOP.companion.SomeS.Foo2

  val f = new Foo2
  f.printObj
}

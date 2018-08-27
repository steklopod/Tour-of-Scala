package companion

class PersonCompanion(var name: String, var age: Int) {

  def this (age: Int){
    this(PersonCompanion.DEFAULT_NAME, age)
  }

  def this(name:String){
    this( name, PersonCompanion.DEFAULT_AGE)
  }

  def this(){
    this(PersonCompanion.DEFAULT_NAME, PersonCompanion.DEFAULT_AGE)
  }
}

// Companion object - хранение констант
object PersonCompanion{
  val DEFAULT_NAME = "Dima"
  val DEFAULT_AGE = 29
}

object DemoPer extends App{
  println(new PersonCompanion("Dima").age)

  //  TODO - вывести
  println(new PersonCompanion("Dima").toString)
}
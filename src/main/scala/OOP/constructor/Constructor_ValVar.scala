package OOP.constructor

class Constructor_ValVar(a: Int, val b: Int, var c: Int) {
  def summ = a + b + c
}

/**
  * Доступ к полям класса:
  * _   - поле
  * val - поле + аксессор
  * var - поле + аксессор + мутатор
  */
object ClassConstructorTest extends App {

  val x = new Constructor_ValVar(1, 2, 3)

  // Нельзя вызвать x.a
  println(x.b) // 2
  println(x.c) // 3
  println(x.summ) // 6

  x.c = 97

  println(x.summ) // 100
}


//2 пример//////////////////////////

class Complex(val real: Double, val image: Double) extends Ordered[Complex] {
  def magnitude            = Math.sqrt(real * real + image * image)
  def angle                = Math.atan2(image, real)
  def +(that: Complex)            = new Complex(this.real + that.real, this.image + that.image)
  def compare(that: Complex): Int = this.magnitude compare that.magnitude

  override def toString = real + " + i*" + image + " | " + magnitude + "*e^(i*" + angle + "))"
}

object Main extends App {
  val first  = new Complex(1, 5)
  val second = new Complex(2, 4)

  if (first > second)   println("Первый больше")
  if (first < second)   println("Второй больше")
  if (first == second)  println("Объекты эквивалентны")
}


class User {
  private[this] var _name: String = ""
  def name                  = _name toUpperCase
  def name_=(name: String)   = _name = { if (name != null) name else "" }
}
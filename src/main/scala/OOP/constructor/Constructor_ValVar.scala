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
  println(x.b)    // 2
  println(x.c)    // 3
  println(x.summ) // 6

  x.c = 97

  println(x.summ) // 100

}

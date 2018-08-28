package OOP.generics

class Stack[A] {
  private var elements: List[A] = Nil

  def push(x: A) {
    elements = x :: elements
  }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}


object Generic_1_Test_1 extends App {

  val stack = new Stack[Int]

  stack.push(1)
  stack.push(2)
    println(stack.pop) // 2
    println(stack.pop) // 1
}


object Generic_1_Test_2 extends App {

  class Fruit

  class Apple extends Fruit
  class Banana extends Fruit

  val stack  = new Stack[Fruit]
  val apple  = new Apple
  val banana = new Banana

  stack.push(apple)
  stack.push(banana)
}

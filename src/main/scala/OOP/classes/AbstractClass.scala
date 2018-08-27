package OOP.classes


abstract class Vehicle(brand: String, maxSpeed: Double) {
  val numWheels: Int

  def ride(): Unit

  def stop(): Unit = println("Stop!")
}

class Car(brand: String, maxSpeed: Double, numSeets: Int) extends Vehicle(brand, maxSpeed) {
  override val numWheels: Int = 4

  override def ride(): Unit = println("wrooom")
}

object AbstractCarTest extends App{
  val bmw = new Car("BMW", 360, 2)

  println(bmw.ride)

  println(bmw.numWheels)

}
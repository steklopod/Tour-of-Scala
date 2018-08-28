package matching

object TypeMatching {

  abstract class Device

  case class Phone(model: String) extends Device{
    def screenOff = "Выключение экрана"
  }
  case class Computer(model: String) extends Device {
    def screenSaverOn = "Включение экранной заставки..."
  }

  def goIdle(device: Device) = device match {
    case p: Phone    => p.screenOff
    case c: Computer => c.screenSaverOn
  }
}

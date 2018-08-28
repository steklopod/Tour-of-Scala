package matching

import java.awt.{Color, Graphics}
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import scala.math._

/**
  * Представим, что у нас есть некоторый набор команд К. Например К = { F, +, - } :
  *     F → пойти прямо
  *     + → повернуть направо
  *     - → повернуть налево
  * */
object FractalLab {
  val w           = 512
  val h           = w; // квадрат 512x512
  val image       = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
  val g: Graphics = image.getGraphics

  var α = 0.0
  var x = 0
  var y: Int = h / 2 // координаты. α - альфа. сохраняйте исходник в UTF-8.

  /**
    * Здесь cmd - обозначает строку с последовательностью различных команд. Например "F−F++F−F", будет означать - прямо, налево, прямо, направо, направо, прямо, налево, прямо.
    * Значение переменных x, y, α будут задавать текущие координаты и направление движения нашей системы.
    *
    * Используем ещё раз силу match и применив какую-нибудь простую L-system-у,
    * напишем программу которая будет рекурсивно создавать нам красивую последовательность команд.
    *
    * Например, пусть будет следующее правило преобразований:
    *     F   →   F+F-F-FF+F+F-F
    *     +   →   +
    *     -   →   -
    */
  def draw(cmd: String, length: Int) {
    cmd foreach {
      case 'F' => {
        g.setColor(Color.red)
        val x2 = (x + length * cos(α)).toInt
        val y2 = (y + length * sin(α)).toInt
        g.drawLine(x, y, x2, y2)
        x = x2
        y = y2
      }
      case '+' => α += 0.5 * Pi
      case '-' => α -= 0.5 * Pi
    }
  }

  // вспомогательная функция генератор цепочки команд
  def generate(s: String, level: Int, f: String => String): String = {
    if (level > 0)
      generate(f(s), level - 1, f)
    else s
  }

  // функция создающая новые команды, на базе старых
  def next(x: String): String = {
    var result = new StringBuilder()
    x.foreach {
      case 'F' => result ++= "F+F-F-FF+F+F-F"
      case i => result += i
    }
    result.toString
  }
}

/**
  * После запуска вы сможете найти созданное изображение в корне проекта с именем "koch.png"
  */
object FractalLabTest extends App {
  import matching.FractalLab._

  // рисуем с шагов 2 пикселя цепочку команда 4 поколения.
  draw(generate("F", 4, next), 2)
  // сохраняем в файл
  ImageIO.write(image, "png", new File("koch.png"))
}
package regex

import regex.Regex_2.{input, keyValPattern}

import scala.util.matching.Regex

object Regexx {
  val numberPattern: Regex = "[0-9]".r

  def isContainsNumber(pswrd: String): Boolean = numberPattern.findFirstMatchIn(pswrd) match {
    case Some(_) => println("Пароль подходит"); true
    case None    => println("Пароль должен содержать число"); false
  }

}

object RegexxTest extends App {
  import regex.Regexx._

  val notContains = isContainsNumber("Без цифры")
  val contains    = isContainsNumber("С цифрой 1")

  require(notContains != contains)
    println("`notContains` Содержит число?: " + notContains)
    println("`contains`    Содержит число?: " + contains)
}

//////////////////////////////////

object Regex_2{

  val keyValPattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r

  val input: String =
    """background-color: #A03300;
      |background-image: url(img/header100.png);
      |background-position: top center;
      |background-repeat: repeat-x;
      |background-size: 2160px 108px;
      |margin: 0;
      |height: 108px;
      |width: 100%;""".stripMargin
}

object Regex_2Test extends App{

  for (patternMatch <- keyValPattern.findAllMatchIn(input))
    println(s"ключ: ${patternMatch.group(1)}, значение: ${patternMatch.group(2)}")
}
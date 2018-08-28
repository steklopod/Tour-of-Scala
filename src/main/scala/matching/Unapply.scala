package matching

object Twice {
  def unapply(num: Int): Option[Int] = if (num % 2 == 0)
    Some(num / 2) else None
}

object TwiceExample extends App {
  val x = 34
  x match {
    case Twice(n) => println(s"Twice $n")
    case _ => println("Not twice")
  }
  println(x)

}


object Even {
  def unapply(num: Int): Boolean = num % 2 == 0
}

object EvenExampe extends App {
  4 match {
    case e@Even() => println(s"$e - четное") //4 чентное
    case e@_ => println(s"$e - нечетное")
  }
}


object Domain {
  def unapplySeq(dom: String): Option[Seq[String]] =
    Some(dom.split("\\."))
}

object DomainExample extends App {
  "google.com" match {
    case Domain("google", "com") => println("Hey, Google") // matches
    case Domain("yahoo", _*) => println("yahoo")
    case _ => println("other")
  }
}

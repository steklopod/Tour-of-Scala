package OOP.case_classes

object CaseClasses extends App{

  case class Message(sender: String, recipient: String, body: String)
  val message1 = Message("guillaume@tut.by", "jorge@catalonia.ru", "Это вы?")

  println(message1.sender)                    // guillaume@tut.by
//  message1.sender = "travis@washington.us"  // не скомпилируется

  // эквивалентность по значению (не по ссылке)
  val message2 = Message("guillaume@tut.by", "jorge@catalonia.ru", "Это вы?")
  val message3 = Message("guillaume@tut.by", "jorge@catalonia.ru", "Это вы?")
  val messagesAreTheSame = message2 == message3  // true

  // копирование
  val message4 = Message("sender@bretagne.fr", "recipient@washington.us", "Текст сообщения")
  val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")

  message5.sender    // recipient@washington.us
  message5.recipient // claire@bourgogne.fr
  message5.body      // "Текст сообщения"

  println("message5.sender: " + message5.sender + "\n message5.recipient: " + message5.recipient + "\n message5.body: " + message5.body)
}

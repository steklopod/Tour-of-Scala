package matching

object PatternGuardsMatching{

  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification
  case class SMS(caller: String, message: String)               extends Notification
  case class VoiceRecording(contactName: String, link: String)  extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _)     => s"У вас письмо от $email с темой: $title"
      case SMS(number, message)       => s"У вас СМС от $number! Сообщение: $message"
      case VoiceRecording(name, link) => s"У вас новое голосовое сообщение от $name! Нажмите чтобы прослушать: $link"
    }
  }
  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
       //шаблон сопоставляется только в том случае, если письмо находится в списке важных людей.
      case Email(email, _, _) if importantPeopleInfo.contains(email) => "У вас письмо от VIP!"
      case SMS(number, _) if importantPeopleInfo.contains(number)    => "У вас СМС от VIP!"
      case other                                                     => showNotification(other)
    }
  }
}

object PatternGuardsTest extends App{
  import matching.PatternGuardsMatching._

  val someSms            = SMS("12345", "Ты здесь?")
  val someVoiceRecording = VoiceRecording("Иван", "voicerecording.org/id/123")
    println(showNotification(someSms))             // У вас  an SMS от 12345! Сообщение: Ты здесь?
    println(showNotification(someVoiceRecording))  // У вас новое голосовое сообщение от Иван! Нажмите чтобы прослушать: voicerecording.org/id/123

  val importantPeopleInfo = Seq("867-5309", "jenny@mail.ru")
  val importantEmail      = Email("jenny@mail.ru", "Выпьем вечером?", "Я свободен после 5!")
  val importantSms        = SMS("867-5309", "Я здесь! Где ты?")
    println(showImportantNotification(someSms, importantPeopleInfo))
    println(showImportantNotification(someVoiceRecording, importantPeopleInfo))
    println(showImportantNotification(importantEmail, importantPeopleInfo))
    println(showImportantNotification(importantSms, importantPeopleInfo))
}

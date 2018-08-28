## Сопоставление с образцом
![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/pattern-matching-syntax.png?raw=true "pattern-matching-syntax")

**Сопоставление с образцом** - это механизм проверки значения по шаблону. Успешое совпадение также может деконструировать 
значение в его составные части. Это более мощная версия оператора _switch_ в Java, и его также можно использовать вместо
 ряда операторов _if / else_.
 
<!-- code -->
```scala
    import scala.util.Random
    
    val x: Int = Random.nextInt(10)
    
    x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    }
```

Значение `x` представляет собой случайное целое число `от 0 до 10`. `x` становится левым операндом оператора соответствия, 
а справа - выражение с четырьмя случаями. Последний случай `_` - это случай «поймать все» для любого числа, большего, чем 2.
 Данный случай также называется `альтернативой`.
 
**Выражения соответствия имеют значение.**

<!-- code -->
```scala
    def matchTest(x: Int): String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "many"
    }
    matchTest(3)  // many
    matchTest(1)  // one
```

Это выражение соответствия имеет тип `String`, потому что все случаи возвращают `String`. Поэтому функция `matchTest` возвращает строку.

### Сопоставление кейс-классов

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/basicPattern.png?raw=true "basicPattern")

Кейс-классы особенно полезны для `паттерн-матчинга`.

<!-- code -->
```scala
    abstract class Notification
    
    case class Email(sender: String, title: String, body: String) extends Notification
    case class SMS(caller: String, message: String)               extends Notification
    case class VoiceRecording(contactName: String, link: String)  extends Notification
```

`Notification` _(Уведомление)_ представляет собой абстрактный суперкласс, который имеет три конкретных типа уведомления, 
реализованных с классами классов `Email`, `SMS` и `VoiceRecording`. Теперь мы можем выполнить сопоставление образцов 
на этих классах классов:

<!-- code -->
```scala
    def showNotification(notification: Notification): String = {
      notification match {
        case Email(email, title, _)     => s"У вас письмо от $email с темой: $title"
        case SMS(number, message)       => s"У вас СМС от $number! Сообщение: $message"
        case VoiceRecording(name, link) => s"У вас новое голосовое сообщение от $name! Нажмите чтобы прослушать: $link"
      }
    }
    val someSms            = SMS("12345", "Ты здесь?")
    val someVoiceRecording = VoiceRecording("Иван", "voicerecording.org/id/123")
    
    println(showNotification(someSms))             // У вас  an SMS от 12345! Сообщение: Ты здесь?
    println(showNotification(someVoiceRecording))  // У вас новое голосовое сообщение от Иван! Нажмите чтобы прослушать: voicerecording.org/id/123
```

Функция `showNotification` принимает в качестве параметра абстрактный тип `Notification` и сопостовляет с типом `Notification` 
(т.е. Определяет, является ли это электронной почтой, `SMS` или `VoiceRecording`). В случае электронной почты 
(`электронная почта`, `название`, `_`) в возвращаемом значении используются поля электронной почты и заголовка, 
но поле тела игнорируется с помощью `_`.

### Шаблоны защиты (pattern guards)

**Шаблоны защиты** - это просто булевы выражения, которые используются для более конкретных случаев. 
Просто добавьте `if <boolean expression>` после шаблона.

<!-- code -->
```scala
    def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
      notification match {
        case Email(email, _, _) if importantPeopleInfo.contains(email) => "У вас письмо от VIP!"
        case SMS(number, _) if importantPeopleInfo.contains(number)    => "У вас СМС от VIP!"
        case other                                                     => showNotification(other) 
      }
    }
    
    val importantPeopleInfo = Seq("867-5309", "jenny@mail.ru")
    
    val someSms            = SMS("867-5309", "Ты здесь?")
    val someVoiceRecording = VoiceRecording("Иван", "voicerecording.org/id/123")
    val importantEmail     = Email("jenny@mail.ru", "Выпьем вечером?", "Я свободен после 5!")
    val importantSms       = SMS("867-5309", "Я здесь! Где ты?")
    
        println(showImportantNotification(someSms, importantPeopleInfo))
        println(showImportantNotification(someVoiceRecording, importantPeopleInfo))
        println(showImportantNotification(importantEmail, importantPeopleInfo))
        println(showImportantNotification(importantSms, importantPeopleInfo))
```                    

В `case Email(email, _, _) if importantPeopleInfo.contains(email)`, 
шаблон сопоставляется только в том случае, если письмо находится в списке важных людей.


### Совпадение только по типу

_Вы можете сопоставлять с типом как в след. примере:_

<!-- code -->
```scala
    abstract class Device
    
    case class Phone(model: String)    extends Device{
       def screenOff     = "Выключение экрана"
    }
    case class Computer(model: String) extends Device {
       def screenSaverOn = "Включение экранной заставки..."
    }
    
    def goIdle(device: Device) = device match {
      case p: Phone    => p.screenOff
      case c: Computer => c.screenSaverOn
    }
```

Метод `goIdle` имеет различное поведение, в зависимости от типа устройства. Это полезно, когда сопоставление должно вызывать 
метод в шаблоне. Существует соглашение **использовать первую букву типа в качестве идентификатора случая** (в данном случае - `p` и `c`).

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)

_Если этот проект окажется полезным тебе - нажми на кнопочку `star` в правом верхнем углу._

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/scala-control-structures.jpg?raw=true "scala-control-structures")

## Конструкторы

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/girl.png "GIRL")
>Как создать класс Scala с несколькими конструкторами (вторичными конструкторами)?

Подход Scala к определению нескольких конструкторов классов немного отличается от Java, но несколько похож. 
Вместо того, чтобы пытаться объяснить это словами, я просто создал примерный исходный код, чтобы продемонстрировать, как это работает.

> примеры кода находятся в пакете `OOP.constructor._`

<!-- code -->
```scala
   class Person(val имя: String, val фамилия: String, val возраст: Int) {
     
       def this(имя: String) {
         this(имя, "", 0)
           println("\n Фамилия и возраст неизвестны.")
       }
     
       def this(имя: String, фамилия: String) {
         this(имя, фамилия, 0)
           println("\n Возраст неизвестен.")
       }
     
       override def toString: String = "%s %s, возраст: %d".format(имя, фамилия, возраст)
   }
   
    object MultipleConstructor extends App {
        val всеАргументы = new Person("Дима", "Колтович", 20)
          println(всеАргументы)
        
        val коля = new Person("Коля", "Воронкович")
          println(коля)
        
        val вася = new Person("Вася")
          println(вася)
    }
```

Результат:

<!-- code -->
```text
    Дима Колтович, возраст: 20
    
     Возраст неизвестен.
    Коля Воронкович, возраст: 0
    
     Фамилия и возраст неизвестны.
    Вася , возраст: 0
```

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/girl.png "GIRL")
>Как создать приватный (private default/primary) конструктор

На практике мне не довадилось пользоваться данным приемом, но я только что видел код, который показывает, как создать 
частный первичный конструктор в Scala, и я решил проверить его и поделиться примером.

Я сделал основной конструктор класса `Order` приватным:

<!-- code -->
```scala
    object PrivateConstructorTests extends App{
        val o = new Order  // ! не компилируется
    }
    
    // обратите внимание на слово 'private'
    class Order private() {
      def this(orderId: Long) {
        this()
        // какой-то код здесь ...
      }  
      
    }
```

### Синтаксис частного первичного конструктора

Основной конструктор сделан приватным в этой, необычно выглядящей, строке кода:

<!-- code -->
```scala
    class Order private() {
```
Этот синтаксис может иметь смысл, если я покажу основной конструктор, который принимает параметр:

<!-- code -->
```scala
    class Order private(customerId: Long) {
```

В любом случае ключевое слово `private` в указанном местоположении **делает основной конструктор закрытым**.

Возвращаясь к первому примеру исходного кода, как вы видели из комментария, включенного в исходный код, эта строка 
кода даже не компилируется, потому что основной конструктор является закрытым:

<!-- code -->
```scala
    val o = new Order  // this won't compile
```

_Опять же, мне еще не понадобилось использовать этот синтаксис «частный конструктор» Scala, но я использовал его в Java, 
когда я хотел применить шаблон `Singleton`, как это сделано в классе Java Calendar._

_Если этот проект окажется полезным тебе - нажми на кнопочку `star` в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
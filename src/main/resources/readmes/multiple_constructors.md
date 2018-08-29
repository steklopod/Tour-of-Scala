## Множественные конструкторы

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/girl.png "GIRL")
>Как создать класс Scala с несколькими конструкторами (вторичными конструкторами)?

Подход Scala к определению нескольких конструкторов классов немного отличается от Java, но несколько похож. 
Вместо того, чтобы пытаться объяснить это словами, я просто создал примерный исходный код, чтобы продемонстрировать, как это работает.

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


_Если этот проект окажется полезным тебе - нажми на кнопочку `star` в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
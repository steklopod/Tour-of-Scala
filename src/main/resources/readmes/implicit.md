## Неявные преобразования (cкрытые классы)

**Скрытые классы** – это классы, которые позволяют нам неявное обращение к первичному конструктору, 
если класс находится в области его видимости.

Для создания неявного класса используется ключевое слово `implicit`.

При работе со скрытыми классами стоит учитывать следующее:

* Скрытые классы должны быть объявлены внутри другого класса, объекта или трейта.

* Скрытый класс может принимать только один не скрытый аргумент и конструктор.

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/implicit.jpg?raw=true "implicit")

_Рассмотрим простой пример:_

<!-- code -->
```scala
   object Squaring {
     implicit class Squarer(x: Int) {
       def numberSquaring[A](f: => A): Unit = {
         println(x + " * " + x + " = " + x * x);
       }
     }
   } 
```

<!-- code -->
```scala
    import Squaring._
    
    object SquaringDemo {
      def main(args: Array[String]) {
        100 numberSquaring();
      }
    }
```

В результате выполнения программы, мы получим, примерно, следующий результат:

<!-- code -->
```sbtshell
    100 * 100 = 10000
    Process finished with exit code 0
```

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
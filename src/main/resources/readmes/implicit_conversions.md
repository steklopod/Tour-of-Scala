## Подразумеваемые преобразования

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/implicit-ex.png?raw=true "OOP.implicit")

> ! сложно для понимания

Неявное преобразование типа `S` в тип `T` определяется неявным значением, имеющим тип функции `S => T`, или 
`неявным методом`, конвертируемым в значение этого типа.

Неявные преобразования применяются в двух ситуациях:

1. Если выражение `e` имеет тип `S`, а `S` не соответствует ожидаемому типу выражения `T`.

2. В выборе `e.m` с `e` типа `S`, если селектор `m` не выражает элемент `S`.

_В первом случае выполняется поиск `c`, для которого применим к `e`, и тип результата которого соответствует `T`._ 

_Во втором случае выполняется поиск `c`, для которого применимо `e`, и результат которого содержит член `с` именем `m`._

Если неявный метод `List[A] => Ordered[List [A]]` находится в области видимости, а также неявный метод 
`Int => Ordered[Int]`, следующая операция в двух списках типа `List[Int]` является законной :

<!-- code -->
```scala
  List(1, 2, 3) <= List(4, 5)
```

Неявный метод `Int => Ordered[Int]` предоставляется автоматически через `scala.Predef.intWrapper`. 
Ниже приведен пример неявного метода `List[A] => Ordered[List [A]]`.

<!-- code -->
```scala
  import scala.language.implicitConversions
  
  implicit def list2ordered[A](x: List[A])
      (implicit elem2ordered: A => Ordered[A]): Ordered[List[A]] = new Ordered[List[A]] { 
      //заменяет на более полезную реализацию
      def compare(that: List[A]): Int = 1
    }
```

Неявно импортированный объект `scala.Predef` объявляет несколько предопределенных типов (_например_, `Pair`) и 
методы (_например_, `assert`), но также несколько неявных преобразований.

_Например_, при вызове метода Java, который ожидает `java.lang.Integer`, вы можете передать ему вместо него `scala.Int`.
 Это связано с тем, что `Predef` включает следующие неявные преобразования:
 
 <!-- code -->
 ```scala
    import scala.language.implicitConversions
    
    implicit def int2Integer(x: Int) =  java.lang.Integer.valueOf(x)
 ```

Поскольку неявные преобразования могут иметь ошибки, если они используются без разбора, компилятор предупреждает 
при компиляции неявного определения преобразования.

Чтобы отключить предупреждения, выполните одно из следующих действий:

* Импортировать `scala.language.implicitConversions` в область определения неявного преобразования;

* Вызов компилятора с `-language:implicitConversions`.

Предупреждение не выдается, когда конверсия применяется компилятором.


_Если этот проект окажется полезным тебе - **нажми на кнопочку `star`** в правом верхнем углу._

[<= Неявные (подразумеваемые) классы и параметры](https://github.com/steklopod/Functions/blob/master/src/main/resources/readmes/implicit.md)

[=> Где Скала ищет неявное](https://github.com/steklopod/Functions/blob/master/src/main/resources/readmes/where_does_scala_look_for_implicits.md)


[<== содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
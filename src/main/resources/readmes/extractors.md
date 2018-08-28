## Экстракторы

**Объект экстрактора** - объектом с методом **`unapply`**. В то время как метод `apply` похож на конструктор, 
который принимает аргументы и создает объект, _`unapply` берет объект и пытается вернуть аргументы._ 
Это чаще всего используется для сопоставления шаблонов и частичных функций.

<!-- code -->
```scala
    import scala.util.Random
    
    object CustomerID {
    
      def apply(name: String) = s"$name--${Random.nextLong}"
    
      def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = customerID.split("--")
          if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
      }
    }
    
    val customer1ID = CustomerID("Дима")  // Дима--23098234908
    customer1ID match {
        case CustomerID(name) => println(name) // prints Дима
        case _                => println("Could not extract a CustomerID")
    }
```

Метод `apply` создает строку `CustomerID` из имени. `Unapply` делает обратное, чтобы вернуть имя. 
Когда мы вызываем `CustomerID(«Дима»)`, это сокращенный синтаксис для вызова `CustomerID.apply («Дима»)`. 
Когда мы вызываем `case CustomerID(name) => println(name)` - мы вызываем метод `unapply`.

Метод `unapply` также может использоваться для назначения значения.

<!-- code -->
```scala
    val customer2ID      = CustomerID("Вася")
    val CustomerID(name) = customer2ID
           println(name)  //  Вася
```

Это эквивалентно `val name = CustomerID.unapply(customer2ID).get`.

<!-- code -->
```scala
    val CustomerID(name2) = "--asdfasdfasdf"
```

Если совпадений не найдено, будет брошено `scala.MatchError`:

<!-- code -->
```scala
    val CustomerID(name3) = "-asdfasdfasdf"
```

Возвращаемый тип `unapply` следует выбирать следующим образом:

* Если это всего лишь тест, верните логическое значение. _Например, `case even ()`;_

* Если он возвращает одно вспомогательное значение типа `T`, верните опцию `[T]`;

* Если вы хотите вернуть несколько под-значений `T1, ..., Tn`, сгруппируйте их в необязательный кортеж `Option[(T1, ..., Tn)]`;

* Иногда количество под-значений не фиксировано, и мы хотели бы вернуть последовательность. 
По этой причине вы также можете определить шаблоны через **`unapplySeq`**, который возвращает `Option[Seq[T]]`. 
Этот механизм используется, например, в списке `case List(x1, ..., xn)`.


[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)

_Если этот проект окажется полезным тебе - нажми на кнопочку `star` в правом верхнем углу._

[еще пример](https://github.com/anton-k/ru-neophyte-guide-to-scala/blob/master/src/p01-extractors.md)
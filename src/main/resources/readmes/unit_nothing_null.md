## Scala и пустота

### Null

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/n.png?raw=true "nothing")
**Null** – это [типаж (trait)](https://github.com/steklopod/Functions/blob/master/src/main/resources/traits.md). Объект `null` (с маленькой буквы) — это как раз и есть объект типа `Null`. 
Он находится **внизу иерархии** типов в Scala, в противовес `AnyRef`.
Благодаря этому вы всегда можете как-бы "занулить" любую ссылку, т.е. присвоить ссылки значение `null`:

<!-- code -->
```scala
    scala> var x = "String"
    x: java.lang.String = String
    
    scala> var i = List(3)
    i: List[Int] = List(3)
    
    scala> i = null
    i: List[Int] = null
    
    scala> x = null
    x: java.lang.String = null
```

`Null` работает только для ссылочных типов, для более общего случая, есть `ничто (Nothing)`.

### Nothing

**Nothing** – это тоже `типаж`. Он находится **на самом дне иерархии** типов, в противовес `Any`. Соответственно, 
это более общий тип, чем `Null` и подходит даже для `AnyVal` объектов (числа, буквы, правда/ложь и т.д.).

В отличие от Null, `Nothing` не может иметь экземпляров (на то оно и ничто). Другими словами **нет аналога `null` для `Nothing`**.

Возникает вопрос, где такое самое "нижнее ничто" может использоваться?
В документации по API можно найти несколько примеров:

<!-- code -->
```scala
// пакет scala.sys
  def error(message: String): Nothing = throw new RuntimeException(message)
```

### Unit

**Unit** – класс, чем-то похоже на `void`, который используется в Java. В Scala тип `Unit` применяется когда нужно показать,
 что функция возвращает пустое значение (но все-таки что-то возвращает, хоть и пустое).

Если открыть документацию, то можно увидеть что:

`class Unit extends Any with AnyVal`

**Внимание! `AnyVal`, а не AnyRef**. Это значит, что `Unit` это не ссылочный тип (в отличие от `Null`). 
Можно сказать, что Unit-у как бы "ближе по родству" будут числа, буквы и другие примитивные типы (которые тоже AnyVal).

В отличие от Nothing, `Unit` повезло больше. Он может иметь свой объект, правда в единственном экземпляре. 
Он обозначается двумя круглыми скобками: `()`. Например:

<!-- code -->
```scala
    scala> val u = ()
    u: Unit = ()
```
Другими словами `Nothing` уместен тогда, когда функция в принципе ничего не возвращает, а `Unit` – это когда возвращает, но оно пустое.
Это отличие существенно. Например результат вызова функции с `Unit` может быть присвоено (в Java с void такой фокус не выйдет).

<!-- code -->
```scala
    scala> def foo():Unit = {}
    foo: ()Unit
    
    scala> val u = foo()
    u: Unit = ()
```

### Nil

**Nil** – объект, пустой список `(extends List[Nothing])`.
Поскольку `Nil` – это список, хоть и пустой, у него как у любого списка есть метод `::` (два двоеточия), с помощью 
которого удобно создавать списки:

<!-- code -->
```scala
    scala> var x = 1 :: 2 :: Nil
    x: List[Int] = List(1, 2)
```
Это возможно благодаря тому, что название метода заканчивается на `:` (двоеточие), в таком случае **метод применяется к 
правому операнду**_ (работает для операторной нотации вызова метода)._

Другими словами, это аналогично вызову: `(Nil.::(2)).::(1)`

Этот метод никогда ничего не возвращает, поэтому возвращаемый тип `Nothing`.

### None

**None** – это такой хитрый объект `(extends Option[Nothing])`, который используется в случае, если мы хотим получить 
что-то, например, из Map, а его там нет.

_Например:_

<!-- code -->
```scala
    scala> var m = Map(1->2)
    m: scala.collection.immutable.Map[Int,Int] = Map(1 -> 2)
    scala> val n = m.get(100)// ну нет такого элемента
    n: Option[Int] = None
```
`None` примечателен тем, что:

* это объект (т.е. синглтон);

* это кейс-объект;

* наследуется от Option[Nothing];

* в случае попытки получить значение (вызвав метод `n.get()`), мы получим исключение: `java.util.NoSuchElementException`.

* если у `None` вызывать метод `isEmpty()` – мы получим `true`.

* поскольку `None` – объект кейс-класса, то мы можем его "матчить" (сопоставлять по шаблону).

<!-- code -->
```scala
    scala> n match { 
     case Some(x) => println("x:" + x) 
     case None => println("none") 
    }
```
Если у `None` вызвать метод `toList()` – мы получим пустой список (т.е. `Nil`).

<!-- code -->
```scala
    scala> n.toList() == Nil
    res21: Boolean = true
```
Поскольку `Non`e объявлен как `extends Option[Nothing]`, а `Nothing` – "самое нижнее ничто", то `None` может работать 
с любыми типами (как с ссылочными так и с примитивными).

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/classes_ier.png "scala_classes")

_Если этот проект окажется полезным тебе - нажми на кнопочку `star` в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
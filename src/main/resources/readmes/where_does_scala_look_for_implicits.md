## Полиморфные методы (где Скала ищет неявное)

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/patricia.png?raw=true "OOP.implicit")

> ! сложно для понимания. Новички в Scala часто спрашивают: **где компилятор ищет `implicits`**?

Методы в Scala можно **`параметризовать`** как `по типу`, так и `по значению`. Синтаксис аналогичен синтаксису 
общих классов. Параметры типа заключены в квадратные скобки, а значения параметров заключены в круглые скобки.

<!-- code -->
```scala
  def listOfDuplicates[A](x: A, length: Int): List[A] = {
    if (length < 1)
      Nil
    else
      x :: listOfDuplicates(x, length - 1)
  }
      println(listOfDuplicates[Int](3, 4))  // List(3, 3, 3, 3)
      println(listOfDuplicates("La", 8))   // List(La, La, La, La, La, La, La, La)
```

Метод `listOfDuplicates` принимает параметр типа `A` и значения параметров `x` и `length`. Значение `x` имеет тип `A`. 
Если длина `<1`, мы возвращаем пустой список. В противном случае мы добавим `x` в список дубликатов, возвращаемых 
рекурсивным вызовом. 

* В первом примере вызова мы явно предоставляем параметр типа, записывая `[Int]`. 
Поэтому первым аргументом должен быть `Int`, а возвращаемым типом будет `List[Int]`.

* Второй пример показывает, что вам не обязательно явно указывать параметр типа. Компилятор часто может вывести его 
на основе контекста или типов аргументов значения. В этом примере `La` - это `String`, поэтому компилятор знает, что 
`A` должен быть строкой.

_Если этот проект окажется полезным тебе - **нажми на кнопочку `star`** в правом верхнем углу._

[<= Неявные преобразования](https://github.com/steklopod/Functions/blob/master/src/main/resources/readmes/implicit_conversions.md)

[<== содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
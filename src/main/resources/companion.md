## Объект компаньен

>Вопрос:

Когда необходим `объект-компаньон` _(singleton)_ для класса? Почему я хочу создать класс, скажем, 
`Foo` а также создать для него объект-компаньон?
![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/girl.png "GIRL")

>Ответ:

`Объект-компаньон` в основном обеспечивает место, где можно ставить `статические методы`. 
Кроме того, _`сопутствующий объект`_ или _`сопутствующий модуль`_ имеет полный доступ к членам класса, включая частные.

`Объект-компаньоны` отлично подходят для инкапсуляции таких вещей, как `фабричные методы`. 
Вместо того чтобы иметь везде, где угодно, `Foo` и `FooFactory`, вы можете иметь класс со спутниковым 
объектом, отвечающим за `фабричные методы`.

<!-- code -->
```scala
    abstract class AbstractClass
    
    class RealThing(s: String) extends AbstractClass
    class AlternativeThing(i: Int) extends AbstractClass
    
    object AbstractClass {
      def apply(s: String) = {
        new RealThing(s)
      }
      def apply(i: Int) = {
        new AlternativeThing(i)
      }
    }
    
    val vs = AbstractClass("asdf")  // дает вам RealThing вещь, обернутую поверх строки
    val vi = AbstractClass(123)   // дает вам AlternativeThing, обернутую поверх числа
```

#### _еще пример:_

<!-- code -->
```scala
    class Person(val firstName: String, val middleName: String, val lastName: String) {}
    
    object Person {
      def apply(firstName: String, lastName: String) = new Person(firstName, "", lastName)
      def apply(firstName: String)                   = new Person(firstName, "", "")
    }
    
    val p = Person("Дима", "Колтович")
```


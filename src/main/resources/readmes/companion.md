## Объект компаньен

>Вопрос:

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/girl.png "GIRL")
Когда необходим `объект-компаньон` _(singleton)_ для класса? Почему я хочу создать класс, скажем, 
`Foo` а также создать для него объект-компаньон?

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

Если вы определяете **класс и объект** в одном файле с тем же именем, они называются `сопутствующим классом 
и объектом`. Scala не имеет статического слова как JAVA, вы можете использовать в качестве замены 
`объект-компаньон` в Scala.

<!-- code -->
```scala
    class Person(val firstName: String, val middleName: String, val lastName: String) {}
    
    object Person {
      def apply(firstName: String, lastName: String) = new Person(firstName, "", lastName)
      def apply(firstName: String)                   = new Person(firstName, "", "")
    }
    
    val p = Person("Дима", "Колтович")
```

Объекты Companion полезны для хранения состояния и методов, которые являются общими для всех экземпляров 
класса, но не используют статические методы или поля. Они используют обычные виртуальные методы, 
которые могут быть переопределены через наследование. **Скала не имеет ничего статического**. 
_Вот простой пример:_

<!-- code -->
```scala
    abstract class AnimalCounter {
      var animals = 0
      def name: String
      def count() {
        animals += 1
        println("%d %ss created so far".format(animals, name))
      }
    }
    
    abstract class Animal {
      def companion: AnimalCounter
      companion.count()
    }
    
    class  Dog extends Animal { def companion = Dog }
    object Dog extends AnimalCounter {
      val name = "dog"
    }
    
    class  Cat extends Animal { def companion = Cat }
    object Cat extends AnimalCounter {
      val name = "cat"
    }
```

Дает вывод:

<!-- code -->
```scala
    scala> new Dog
    1 dogs created so far
    
    scala> new Cat
    1 cats created so far
    
    scala> new Dog
    2 dogs created so far
    
    scala> new Cat
    2 cats created so far
```

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/girl.png "GIRL")
### Как создать статические элементы в Скала?

_Это выдержка из **Поваренной книги Scala** (частично измененной для Интернета). 
Рецепт 6.6, «Как создать статические члены с объектами-компаньонами Scala»._

#### Проблема

Вы хотите создать класс, который имеет как `методы экземпляра`, так и `статические методы`, 
но в отличие от Джава, **Скала не имеет ключевого слова `static`**.

#### Решение

Определите `нестатические (экземпляры)/non-static (instance)  члены` в вашем классе и определите члены, 
которые вы хотите отображать `как статические члены` в объекте, который имеет **то же имя, 
что и класс**, и **находится в том же файле, что и класс**. Этот объект известен как `объект компаньен`.

Используя этот подход, вы можете создать то, что **кажется статическим членом класса** (оба поля и методы), 
как показано в этом примере:

<!-- code -->
```scala
// Pizza class
class Pizza (var crustType: String) {
    override def toString = "тип теста " + crustType
}

// companion object
object Pizza {
    val CRUST_TYPE_THIN = "тонкая"
    val CRUST_TYPE_THICK = "толстая"
    def getFoo = "Foo"
}
```

С `классом Pizza` и `объектом Pizza`, определенным в том же файле (предположительно с именем `Pizza.scala`),
 `члены объекта Pizza` **могут быть доступны как статические члены класса Java**:
 
 <!-- code -->
 ```scala
 println(Pizza.CRUST_TYPE_THIN)
 println(Pizza.getFoo)
 ```
 
 Вы также можете создать `новый экземпляр Pizza` и использовать его как обычно:
 
 <!-- code -->
 ```scala
     var p = new Pizza(Pizza.CRUST_TYPE_THICK)
     println(p)
 ```
 
 Если вы переходите на Scala с языка, отличного от Java, `статические методы в Java` - _это методы, 
 которые можно вызывать непосредственно в классе, не требуя экземпляра класса_. Вот пример метода с 
 именем `increment в объекте Scala` с именем `StringUtils`:
 
 <!-- code -->
 ```scala
      object StringUtils {
          def increment(s: String) = s.map(c => (c + 1).toChar)
      }   
```

Поскольку он определен внутри объекта (а не класса), метод приращения можно вызвать непосредственно `в 
объекте StringUtils`, **не требуя создания экземпляра `StringUtils`**:

<!-- code -->
```scala
    scala> StringUtils.increment("HAL")
    res0: String = IBM
```

Фактически, когда объект определен таким образом без соответствующего класса, вы не можете создать 
его экземпляр. Эта строка кода не будет компилироваться: `val utils = new StringUtils`.

Хотя этот подход отличается от Java, рецепт прост:

* Определите свой класс и объект в том же файле, присвоив им одно и то же имя;

* Определите элементы, которые должны быть «статичными» в объекте;

* Определите нестатические (экземпляры) членов в классе.

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/girl.png "GIRL")
#### Доступ к приватным полям

Также важно знать, что класс и его сопутствующий объект могут обращаться к частным членам друг друга.
 В следующем коде «статический» метод `double` в объекте может получить доступ к приватной 
 переменной класса `Foo`:
 
 <!-- code -->
 ```scala
      class Foo {
          private val secret = 2
      }
      
      object Foo {
          // доступ к приватному полю класса 'secret'
          def double(foo: Foo) = foo.secret * 2
      }
      
      object Driver extends App {
          val f = new Foo
          println(Foo.double(f))  // prints 4
      }
```

Аналогично, в следующем коде член экземпляра `printObj` может обращаться к частному полю `obj` 
объекта `Foo`:

<!-- code -->
```scala
    class Foo {
        // доступ к приватному полю объекта 'obj'
        def printObj { println(s"I can see ${Foo.obj}") }
    }
    
    object Foo {
        private val obj = "Foo's object"
    }
    
    object Driver extends App {
        val f = new Foo
        f.printObj
    }
```

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
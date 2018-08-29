## Именованные аргументы и аргументы по умолчанию

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/Scala-function-named-arguments.jpg "named-arguments")

### Именованные аргументы

С помощью `именованных аргументов (параметров)` Scala вы можете указать имена аргументов 
функции или метода при вызове метода. 

<!-- code -->
```scala
    object NamedArguments extends App {
      def printName(firstName: String, lastName: String) {
        System.out.format("Ваше имя и фамилия:%s %s\n", firstName, lastName)
      }
    
      printName(firstName = "Колтович", lastName = "Дима")
    }
```

Как вы можете видеть из этого примера, я создаю функцию `printName` обычным способом, и тогда я могу вызвать ее:

<!-- code -->
```scala
    printName(firstName="Колтович", lastName="Дима")
```

Здесь я использую имена параметров функции при вызове функции. Хотя данная запись более подробная, она также может 
сделать ваш код более легким для чтения.

Однако, если вам не нравится подход с именованным параметром, очень хорошая вещь о Scala заключается в том, что этот
 синтаксис является полностью необязательным, и вы все равно можете вызвать свою функцию без именованных параметров:

<!-- code -->
```scala
    printName("Колтович", "Дима")
```

### Значения аргументов функции по умолчанию

При написании функции Scala вы также можете объявлять значения по умолчанию для аргументов функции. Для этого вам 
нужно только указать значение аргумента после объявления аргумента следующим образом:

<!-- code -->
```scala
    def printName(firstName: String = "Неизвестен", lastName: String = "Неизвестен") {
      System.out.format("Ваше имя и фамилия: %s %s\n", firstName, lastName)
    }
```

После того, как вы объявили о своей функции или методе, вы можете вызвать вашу функцию различными способами, как показано здесь:

<!-- code -->
```scala
    printName("Колтович", "Дима")
    printName("Колтович")
    printName()
```

Эти три вызова приводят к следующему результату:

<!-- code -->
```text
    Ваше имя и фамилия: Колтович Дима
    Ваше имя и фамилия: Колтович Неизвестен
    Ваше имя и фамилия: Неизвестен Неизвестен
```


_Если этот проект окажется полезным тебе - нажми на кнопочку `star` в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
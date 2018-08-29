## Try, catch, finally синтаксис (несколько исключений, подстановочный оператор)

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/images/try-catch.png "try-catch")

Общий синтаксис Scala `try/catch/finally` выглядит следующим образом:

<!-- code -->
```scala
   try
   {
     // здесь код
   } 
   catch
   {
     case foo: FooException => handleFooException(foo)
     case bar: BarException => handleBarException(bar)
     case _: Throwable => println("Got some other kind of exception")
   }
   finally
   {
     // здесь код, например, закрытие рессурсов
   } 
```

Как вы можете видеть, синтаксис Scala `try-catch-finally` похож на синтаксис try-catch-finally Java, за исключением 
области **`catch`**, которая использует возможности `сопоставления шаблонов` Scala для обработки различных исключений, 
с которыми вы могли столкнуться.

В этом примере я намеренно поймаю `FooException` и `BarException`, а затем я использую подстановочный шаблон Scala 
`_` для обнаружения любых других исключений, которые могут возникнуть.

### Использование подстановочного оператора Scala `_` в catch-блоке

Один из недостатков использования подстановочного символа Scala `(_)` в предложении `catch` заключается в том, что 
вы не можете ссылаться на него в своем коде, например, если вы хотите распечатать исключение.

В отличной книге «Программирование Scala» авторы предлагают называть вашу переменную исключения вместо использования 
подстановочного знака, который вы можете затем ссылаться на свой собственный код, примерно так:

<!-- code -->
```scala
    catch
    {
      //...
      case unknown => println("Отловлено неизвестное исключение: " + unknown)
    }
```

Как вы можете видеть из этого кода, я просто называю переменную `unknown`, которую я тогда могу назвать по имени.

### Печать трассировки стека исключений Scala

Наконец, вот еще пример Scala `try / catch`, где я демонстрирую, как печатать трассировку стека из исключения:


<!-- code -->
```scala
    def runAppleScriptCommand(c: AppleScriptCommand) {
      val scriptEngineManager = new ScriptEngineManager
      try {
        scriptEngineManager.eval(c.command)
      } catch {
        case e: ScriptException => e.printStackTrace
      }
    }
```

_Если этот проект окажется полезным тебе - нажми на кнопочку `star` в правом верхнем углу._

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)
## Регулярные выражения

**Регулярные выражения** - это строки, которые могут использоваться для поиска шаблонов (или их отсутствия) в данных. 
Любая строка может быть преобразована в регулярное выражение с использованием метода `.r`.

<!-- code -->
```scala
    import scala.util.matching.Regex
    
    val numberPattern: Regex = "[0-9]".r
    
    numberPattern.findFirstMatchIn("awesomepassword") match {
      case Some(_) => println("Пароль подходит")
      case None    => println("Пароль должен содержать число")
    }
```

В приведенном выше примере `numberPattern` является регулярным выражением (регулярное выражение), которое мы используем, 
чтобы убедиться, что пароль содержит число.

Вы также можете искать группы регулярных выражений с помощью круглых скобок.

<!-- code -->
```scala
    import scala.util.matching.Regex
    
    val keyValPattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r
    
    val input: String =
      """background-color: #A03300;
        |background-image: url(img/header100.png);
        |background-position: top center;
        |background-repeat: repeat-x;
        |background-size: 2160px 108px;
        |margin: 0;
        |height: 108px;
        |width: 100%;""".stripMargin
    
    for (patternMatch <- keyValPattern.findAllMatchIn(input))
      println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
```

[<= содержание](https://github.com/steklopod/Functions/blob/master/readme.md)

[wiki](https://ru.wikipedia.org/wiki/Регулярные_выражения)

[хабр](https://habr.com/post/115825/)

[еще ссылка](http://developer.alexanderklimov.ru/regexp.php)
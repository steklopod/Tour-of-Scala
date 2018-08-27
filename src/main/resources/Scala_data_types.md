## Типы данных в Скала

![alt text](https://github.com/steklopod/Functions/blob/master/src/main/resources/girl.png "GIRL")
Каковы типы данных Scala? Сколько бит они используют для хранения своих данных? Каков диапазон этих типов данных?


<!-- code -->
```text
    Data Type  Definition
    
    Boolean    true or false
    
    Byte       8-bit signed two's complement integer (-2^7 to 2^7-1, inclusive)
               -128 to 127
    
    Short      16-bit signed two's complement integer (-2^15 to 2^15-1, inclusive)
               32,768 to 32,767
    
    Int        32-bit two's complement integer (-2^31 to 2^31-1, inclusive)
               2,147,483,648 to 2,147,483,647
    
    Long       64-bit two's complement integer (-2^63 to 2^63-1, inclusive)
               -9,223,372,036,854,775,808 to +9,223,372,036,854,775,807
    
    Float      32-bit IEEE 754 single-precision float
               1.40129846432481707e-45 to 3.40282346638528860e+38 (positive or negative)
    
    Double     64-bit IEEE 754 double-precision float
               4.94065645841246544e-324d to 1.79769313486231570e+308d (positive or negative)
    
    Char       16-bit unsigned Unicode character (0 to 2^16-1, inclusive)
               0 to 65,535
    
    String     последовательность Chars (Символов)

```

**Примечания о типах данных Scala**

Класс `String` находится в пакете `java.lang`, и все остальные типы находятся `в пакете scala`.

Возможно, вы заметили, что эти типы данных в Scala имеют тот же диапазон, что и соответствующие типы данных в Java. 
Это упрощает преобразование этих типов Scala в соответствующие им примитивные типы Java.

В совокупности `Byte`, `Short`, `Int`, `Long` и `Char` называются **интегральными типами**. 
`Интегральные типы` плюс `Float` и `Double` называются **числовыми типами**. 


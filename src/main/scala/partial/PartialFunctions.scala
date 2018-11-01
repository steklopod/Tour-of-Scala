package partial

object PartialFunctions extends App {

  val foo: PartialFunction[Int, Int] = {
    case pos if pos > 0 => pos * pos
  }

  val bar: PartialFunction[Int, Int] = {
    case neg if neg < 0 => neg + neg
  }

//  val zero: PartialFunction[Int, String] ={
//    case 0 ⇒ s"ZERO"
//  }

  val chained = foo orElse bar /* orElse zero */

  println( chained )                   //<function1>

  println( chained.isDefinedAt(4) )    //true

  println( chained(4) )                //16

  println( chained.isDefinedAt(-4) )   //true

  println( chained(-4) )               //-8

//  println( chained(0) )   //ZERO
//  println(chained(0))     //Exception in thread "main" scala.MatchError: 0 (of class java.lang.Integer)

}

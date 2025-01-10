```scala
class MyClass[T](val value: T) {
  def myMethod(implicit evidence: T => Int): Int = {
    try {
      evidence(value)
    } catch {
      case e: NumberFormatException => {
        println(s"Error converting to Int: "+ e.getMessage)
        0 // Or handle appropriately
      }
    }
  }
}

object Main extends App {
  implicit val intToInt: Int => Int = identity
  val myInt = new MyClass(5)
  println(myInt.myMethod) // Works fine

  implicit val stringToInt: String => Int = _.toInt
  val myString = new MyClass("5")
  println(myString.myMethod) // Now handles exception
  val myString2 = new MyClass("abc")
  println(myString2.myMethod) //Handles exception
}
```
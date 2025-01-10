```scala
class MyClass[T](val value: T) {
  def myMethod(implicit evidence: T => Int): Int = evidence(value)
}

object Main extends App {
  implicit val intToInt: Int => Int = identity
  val myInt = new MyClass(5)
  println(myInt.myMethod) // Works fine

  implicit val stringToInt: String => Int = _.toInt
  val myString = new MyClass("5")
  println(myString.myMethod) // Throws exception if not handled
}
```
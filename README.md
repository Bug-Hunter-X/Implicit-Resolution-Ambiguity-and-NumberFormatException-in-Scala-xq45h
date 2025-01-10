# Scala Implicit Resolution Ambiguity and NumberFormatException

This example demonstrates a common issue in Scala related to implicit resolution and type parameter handling. The code uses implicit conversions to allow a method to accept different types but can fail unexpectedly with ambiguous implicit resolution. 

The `MyClass` uses an implicit conversion to an `Int` in its `myMethod`. While this works fine for `Int`, it throws a `NumberFormatException` when attempting to convert a String to an `Int` if the string is not a valid integer representation.

The solution involves handling the potential exception to enhance robustness.
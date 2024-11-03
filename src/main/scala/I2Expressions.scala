package fr.gplassard.scalapresentation

object I2Expressions extends App {

  def foobar(value: Int): String = {
    val result = if (value % 3 == 0 && value % 5 == 0) "foobar"
      else if (value % 3 == 0) "foo"
      else if (value % 5 == 0) "bar"
      else value.toString
    result
  }
  println(foobar(5))  // bar
  println(foobar(6))  // foo
  println(foobar(7))  // 7
  println(foobar(15)) // foobar


  def combine(chars: Seq[Char], ints: Seq[Int]) = for {
    char <- chars
    int <- ints
  } yield s"$char$int"
  println(combine(('a' to 'c'), (1 to 4))) // Vector(a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4)

}

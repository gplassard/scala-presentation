package fr.gplassard.scalapresentation

object I3ReferentialTransparency extends App {

  def addTransparent(a: Int, b: Int): Int = a + b

  var counter = 0
  def addNotTransparent(a: Int, b: Int): Int = {
    println(s"I'm adding ${a} and $b")
    counter += 1
    a + b
  }

  // can be replaced by `val six = 6`
  val six = addTransparent(addTransparent(1, 2), addTransparent(3, 0))

  // can NOT be replaced by `val ten = 10`
  val ten = addNotTransparent(addNotTransparent(5, 2), 3)

}

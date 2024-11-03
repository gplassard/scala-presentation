package fr.gplassard.scalapresentation

object I1Immutability extends App {

  case class User(firstName: String, lastName: String)

  val user1 = User("firstName_1", "lastName")
  println(user1) // User(firstName_1,lastName)

  val user2 = user1.copy(firstName = "firstName_2")
  println(user1) // User(firstName_1,lastName)
  println(user2) // User(firstName_2,lastName)


  val firstList = List("foo", "bar")
  val secondList = firstList :+ ("foobar")
  val charsCount = secondList
    .flatMap(_.toList)
    .groupBy(Predef.identity)
    .view
    .mapValues(_.size)
    .toMap
  println(secondList) // List(foo, bar, foobar)
  println(charsCount) // HashMap(f -> 2, a -> 2, b -> 2, r -> 2, o -> 4)

}

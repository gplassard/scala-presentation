package fr.gplassard.scalapresentation

object I8TypeDrivenDevelopment extends App {

  def firstName(present: Boolean): Option[String] =
    if (present) Some("Example firstName")
    else None

  println(firstName(true).map(_.toUpperCase))
  println(firstName(false).map(_.toUpperCase))
  println(firstName(false).getOrElse("default firstname"))

  case class User(firstName: User.FirstName, lastName: User.LastName)
  object User {
    opaque type FirstName = String
    opaque type LastName = String

    object FirstName {
      def apply(value: String): FirstName = value
    }
    object LastName {
      def apply(value: String): LastName = value
    }
  }

  val firstName = User.FirstName("example_firstname")
  val lastName = User.LastName("example_lastname")
  //println(User(lastName, firstName)) // does not compile
  println(User(firstName, lastName)) // User(example_firstname,example_lastname)



  type OneOr2 = 1 | 2
  val one: OneOr2 = 1
  // val three: OneOr2 = 3 // does not compile

  sealed trait JSON
  case class JStr(v: String) extends JSON
  case class JNum(v: Double) extends JSON
  case class JBool(v: Boolean) extends JSON
  case object JNull extends JSON
  case class JArray(v: Seq[JSON]) extends JSON
  case class JObject(v: Map[String, JSON]) extends JSON

  def print(json: JSON): String = json match {
    case JStr(v) => "\"" + v + "\""
    case JNum(v) => v.toString
    case JBool(v) => v.toString
    case JNull => "null"
    case JArray(v) => v.map(print).mkString("[", ", ", "]")
    case JObject(v) => v.map((key, value) => s"\"$key\": ${print(value)}").mkString("{", ", ", "}")
  }
  println(print(JArray(Seq(JNull, JObject(Map("a" -> JBool(false), "b" -> JStr("hello")))))))
  // [null, {"a": false, "b": "hello"}]
}

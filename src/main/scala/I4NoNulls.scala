package fr.gplassard.scalapresentation

object I4NoNulls extends App {

  def firstName(present: Boolean): Option[String] =
    if (present) Some("Example firstName")
    else None

  println(firstName(true).map(_.toUpperCase))  // Some(EXAMPLE FIRSTNAME)
  println(firstName(false).map(_.toUpperCase))  // None
  println(firstName(false).getOrElse("default firstname")) // default firstname

}

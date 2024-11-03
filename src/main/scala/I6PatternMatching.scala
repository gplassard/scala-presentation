package fr.gplassard.scalapresentation

import scala.util.{Success, Failure}

object I6PatternMatching extends App {

  I4NoNulls.firstName(false) match {
    case None => println("There is no firstName") // There is no firstName
    case Some(firstName) => println(s"Got firstName $firstName")
  }

  I5ErrorHandling.division1(1, 0) match {
    case Left(error) => println(s"Got error $error") // Got error DivideByZero
    case Right(value) => println(s"Got result $value")
  }

  I5ErrorHandling.division2(1, 0) match {
    case Failure(error) => println(s"Got error $error") // Got error java.lang.IllegalArgumentException: Can't divide by zero
    case Success(value) => println(s"Got result $value")
  }

}

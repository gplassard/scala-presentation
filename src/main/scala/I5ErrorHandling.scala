package fr.gplassard.scalapresentation

import scala.util.{Failure, Success, Try}

object I5ErrorHandling extends App {

  case object DivideByZero

  def division1(left: Int, right: Int): Either[DivideByZero.type , Double] =
    if (right == 0) Left(DivideByZero)
    else Right(left / right)

  println(division1(4, 2))  // Right(2.0)
  println(division1(4, 0))  // Left(DivideByZero)
  println(division1(4, 0).isLeft)  // false

  def division2(left: Int, right: Int): Try[Double] =
    if (right == 0) Failure(IllegalArgumentException("Can't divide by zero"))
    else Success(left / right)

  println(division2(4, 2))  // Success(2.0)
  println(division2(4, 0))  // Failure(java.lang.IllegalArgumentException: Can't divide by zero)
  println(division2(4, 0).isSuccess)  // false

}

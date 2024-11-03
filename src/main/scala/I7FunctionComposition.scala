package fr.gplassard.scalapresentation

object I7FunctionComposition extends App {

  // Define the type alias for ValidationResult
  type ValidationResult[A] = Either[String, A]

  def isNotEmpty(value: String): ValidationResult[String] =
    if (value.isEmpty) Left("Input cannot be empty")
    else Right(value)

  def minLength(min: Int)(value: String): ValidationResult[String] =
    if (value.length < min) Left(s"Input must be at least $min characters long")
    else Right(value)

  def maxLength(max: Int)(value: String): ValidationResult[String] =
    if (value.length > max) Left(s"Input must be at most $max characters long")
    else Right(value)

  def isEmail(value: String): ValidationResult[String] = {
    val emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$".r
    if (emailRegex.matches(value)) Right(value)
    else Left("Input must be a valid email address")
  }

  // A function to compose multiple validators
  def combineValidators[A](validators: (A => ValidationResult[A])*): A => ValidationResult[A] =
    input => validators.foldLeft(Right(input): ValidationResult[A]) {
      (acc, validator) => acc.flatMap(validator)
    }

  // Define a composed validator
  val validateUsername: String => ValidationResult[String] = combineValidators(isNotEmpty, minLength(3), maxLength(15))
  val validateEmail: String => ValidationResult[String] = combineValidators(isNotEmpty, isEmail)

  println(validateUsername("user123")) // Right(user123)
  println(validateEmail("user@example.com")) // Right(user@example.com)
  println(validateUsername("")) // Left(Input cannot be empty)
  println(validateEmail("not-an-email")) // Left(Input must be a valid email address)
}

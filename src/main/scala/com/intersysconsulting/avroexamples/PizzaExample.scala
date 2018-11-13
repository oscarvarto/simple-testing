package com.intersysconsulting.avroexamples

import java.io.IOException

import scalaz.zio.{App, IO}
import scalaz.zio.console._
import com.sksamuel.avro4s.AvroSchema
import org.apache.avro.Schema

object PizzaExample extends App {

  case class Ingredient(name: String, sugar: Double, fat: Double)

  case class Pizza(name: String,
                   ingredients: Seq[Ingredient],
                   vegetarian: Boolean,
                   vegan: Boolean,
                   calories: Int)

  val ingredientSchema: Schema = AvroSchema[Ingredient]
  val pizzaSchema: Schema = AvroSchema[Pizza]

  def run(args: List[String]): IO[Nothing, ExitStatus] =
    myAppLogic.attempt.map(_.fold(_ => 1, _ => 0)).map(_ => ExitStatus.DoNotExit)

  def myAppLogic: IO[IOException, Unit] =
    for {
      _ <- putStrLn(s"Schema: ${pizzaSchema.toString(true)}")
    } yield ()
}

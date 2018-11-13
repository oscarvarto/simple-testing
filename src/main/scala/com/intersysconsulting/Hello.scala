package com.intersysconsulting

import scalaz.syntax.show._
import scalaz.std.anyVal.doubleInstance
import scalaz.zio.{App, IO}
import scalaz.zio.console._
import spire.algebra._
import spire.math._
import spire.implicits._
import java.io.IOException


import spire.std.ArrayCoordinateSpace

object Hello extends App with Greeting {

  def run(args: List[String]): IO[Nothing, ExitStatus] =
    myAppLogic.attempt.map(_.fold(_ => 1, _ => 0)).map(_ => ExitStatus.DoNotExit)

//  val a1 = Array(0.0, 3.0)
//  val a2 = Array(4.0, 0.0)
//
//  val d = a1.distance(a2)

  //val msg = EuclideanDistance.d1.fold(identity, _.shows)
  val msg = 5.0.shows
  /*
  def myAppLogic: IO[IOException, Unit] =
    for {
      _ <- putStrLn("Hello! What is your name?")
      n <- getStrLn
      _ <- putStrLn("Hello, " + n + ", good to meet you!")
    } yield ()
  */

  def myAppLogic: IO[IOException, Unit] =
    for {
      _ <- putStrLn(s"Distance: $msg")
    } yield ()


}

trait Greeting {
  lazy val greeting: String = "hello"
}

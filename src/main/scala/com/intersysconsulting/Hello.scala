package com.intersysconsulting

import java.io.IOException

import scalaz.zio.console._
import scalaz.zio.{App, IO}

object Hello extends App with Greeting {

  def run(args: List[String]): IO[Nothing, ExitStatus] =
    myAppLogic.attempt.map(_.fold(_ => 1, _ => 0)).map(_ => ExitStatus.DoNotExit)

  def myAppLogic: IO[IOException, Unit] =
    for {
      _ <- putStrLn("Hello! What is your name?")
      n <- getStrLn
      _ <- putStrLn("Hello, " + n + ", good to meet you!")
    } yield ()
}

trait Greeting {
  lazy val greeting: String = "hello"
}

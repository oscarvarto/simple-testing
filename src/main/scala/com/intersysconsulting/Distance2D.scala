package com.intersysconsulting

import java.io.IOException

import scalaz.std.anyVal.doubleInstance
import scalaz.syntax.show._
import scalaz.zio.console._
import scalaz.zio.{App, IO}
import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.Size
import eu.timepit.refined.generic.Equal
import spire.implicits._
import spire.algebra._
import spire.std.SeqMaxNormedVectorSpace

object Distance2D extends App {
  type S2 = Size[Equal[W.`2`.T]]
  type V2[T] = Vector[T] Refined S2
  type Error = String
  type V2Ref[T] = Either[Error, V2[T]]

  def euclideanDistance2D(v1: Vector[Double], v2: Vector[Double]): Either[Error, Double] =
    for {
      _ <- refineV[S2](v1)
      _ <- refineV[S2](v2)
    } yield v1.distance(v2)

  def distance2D[F](v1: Vector[F], v2: Vector[F])(implicit ev: NormedVectorSpace[Vector[F], F]): Either[Error, F] =
    for {
      _ <- refineV[S2](v1)
      _ <- refineV[S2](v2)
    } yield v1.distance(v2)

  val a1 = Vector(0.0, 3.0)
  val a2 = Vector(4.0, 0.0)

  val d1: Either[Error, Double] = euclideanDistance2D(a1, a2)
  val d2 = distance2D(a1, a2)(new SeqMaxNormedVectorSpace())

  val msg = d1.fold(identity, _.shows)


  def run(arg: List[String]): IO[Nothing, ExitStatus] =
    myAppLogic.attempt.map(_.fold(_ => 1, _ => 0)).map(_ => ExitStatus.DoNotExit)

  def myAppLogic: IO[IOException, Unit] =
    for {
      _ <- putStrLn(s"Distance: $msg")
    } yield ()
}

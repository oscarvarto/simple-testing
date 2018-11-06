import sbt._

object Dependencies {
  lazy val scalazCore     = "org.scalaz"            %% "scalaz-core"      % "7.2.27"
  lazy val scalazZio      = "org.scalaz"            %% "scalaz-zio"       % "0.3.2"
  lazy val refined        = "eu.timepit"            %% "refined"          % "0.9.2"
  lazy val refinedScalaz  = "eu.timepit"            %% "refined-scalaz"   % "0.9.2"
  lazy val newtype        = "io.estatico"           %% "newtype"          % "0.4.2"
  lazy val spire          = "org.typelevel"         %% "spire"            % "0.16.0"
  lazy val scalaTest      = "org.scalatest"         %% "scalatest"        % "3.2.0-SNAP10"
  lazy val scalaCheck     = "org.scalacheck"        %% "scalacheck"       % "1.14.0"
}

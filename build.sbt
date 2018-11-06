import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.13.0-M5",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "simple-testing",
    libraryDependencies ++= Seq(
      scalazCore withJavadoc(),
      scalaTest % Test
    )
  )

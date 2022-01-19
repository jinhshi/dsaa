lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      scalaVersion := "2.12.15"
    )),
    name := "data structures and algorithms"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
// https://mvnrepository.com/artifact/org.scala-lang/scala-library
libraryDependencies += "org.scala-lang" % "scala-library" % "2.12.15"
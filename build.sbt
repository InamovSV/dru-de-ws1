import sbt.Keys.scalaVersion

name := "dru-de-ws1"

version := "0.1"

scalaVersion := "2.12.6"

lazy val model = Project(id = "model", base = file("model"))
  .settings(
    version := "0.1",
    scalaVersion := "2.12.6"
  )

lazy val dataTables = Project("datatables", file("datatables"))
  .dependsOn(model)
  .settings(
    version := "0.1",
    scalaVersion := "2.12.6"
  )

lazy val root = Project("workshop", file("."))
  .aggregate(dataTables, model)


lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.11.8"
)

lazy val core = (project in file("core"))
  .settings(name = "scala-gles-core")
  .settings(commonSettings)

lazy val jogl = (project in file("jogl"))
  .settings(name = "scala-gles-jogl")
  .settings(commonSettings)
  .dependsOn(core)

lazy val root = (project in file("."))
  .dependsOn(jogl)
  .aggregate(core, jogl)

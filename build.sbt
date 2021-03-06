
lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.11.11",
  scalacOptions ++= Seq(
    "-deprecation",
    "-unchecked",
    "-optimise",
    "-feature",
    "-Yinline-warnings"
  )
)

lazy val core = (project in file("core"))
  .settings(name := "scalagl-core")
  .settings(commonSettings)

lazy val jogl = (project in file("jogl"))
  .settings(
    name := "scalagl-jogl",
    resolvers += MavenRepository("jogamp", "http://jogamp.org/deployment/maven"),
    libraryDependencies += "org.jogamp.jogl" % "jogl-all-main" % "2.3.2",
    libraryDependencies += "org.jogamp.gluegen" % "gluegen-rt-main" % "2.3.2")
  .settings(commonSettings)
  .dependsOn(core)

lazy val lwjgl = (project in file("lwjgl"))
  .settings(
    name := "scalagl-lwjgl",
    libraryDependencies += "org.lwjgl" % "lwjgl" % "3.1.0",
    libraryDependencies += "org.lwjgl" % "lwjgl-opengles" % "3.1.0")
  .settings(commonSettings)
  .dependsOn(core)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .dependsOn(jogl, lwjgl)
  .aggregate(core, jogl, lwjgl)

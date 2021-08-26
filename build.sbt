enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(PackPlugin)
import com.typesafe.sbt.packager.docker.{DockerChmodType, ExecCmd}

name := "CastTest"

version := "0.1"

scalaVersion := "2.13.6"

resolvers ++= Seq(
  "local ivy Repository" at "file://" + Path.userHome.absolutePath + "/.ivy2/local"
)
routesGenerator := InjectedRoutesGenerator

lazy val `cast` = (project in file(".")).enablePlugins(LagomScala).settings(lagomServiceHttpPort := 11111)
  .disablePlugins(LagomLogback)
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi,
      "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided",
      jdbc))


lagomKafkaEnabled in ThisBuild := false
lagomCassandraEnabled in ThisBuild := false

dockerChmodType := DockerChmodType.UserGroupWriteExecute

javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)

packMain := Map("CastTest"->"play.core.server.ProdServerStart")

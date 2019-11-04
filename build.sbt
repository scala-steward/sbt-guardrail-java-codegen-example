
enablePlugins(GuardrailPlugin)

name := "sbt-guardrail-java-codegen-example"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.10"

scalacOptions += "-Xexperimental"

guardrailTasks in Compile := List(
  JavaClient(file("petstore.json"), pkg="com.example.clients.petstore", imports=List("support.PositiveLong")),
  JavaServer(file("petstore.json"), pkg="com.example.servers.petstore", imports=List("support.PositiveLong"))
)

val dropwizardVersion = "1.3.16"

libraryDependencies ++= Seq(
  "io.dropwizard"                % "dropwizard-core"       % dropwizardVersion,
  "javax.xml.bind"               % "jaxb-api"              % "2.3.1",
  "org.scalatest"               %% "scalatest"             % "3.0.8" % "test"
)

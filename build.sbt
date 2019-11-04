
enablePlugins(GuardrailPlugin)

name := "sbt-guardrail-java-codegen-example"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.10"

scalacOptions += "-Xexperimental"

compileOrder := CompileOrder.JavaThenScala

guardrailTasks in Compile := List(
  JavaClient(file("petstore.json"), pkg="com.example.clients.petstore", imports=List("support.PositiveLong")),
  JavaServer(file("petstore.json"), pkg="com.example.servers.petstore", imports=List("support.PositiveLong"))
)

// workaround for SBT issue
unmanagedSourceDirectories in Compile := Seq((sourceManaged in Compile).value)

val dropwizardVersion = "1.3.16"

libraryDependencies ++= Seq(
  "io.dropwizard"                % "dropwizard-core"         % dropwizardVersion,
  "org.asynchttpclient"          % "async-http-client"       % "2.8.1",
  "org.glassfish.jersey.media"   % "jersey-media-multipart"  % "2.25.1",
  "javax.xml.bind"               % "jaxb-api"                % "2.3.1",
  "org.scalatest"               %% "scalatest"               % "3.0.8" % "test"
)

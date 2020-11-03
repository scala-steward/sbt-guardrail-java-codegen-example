
enablePlugins(GuardrailPlugin)

name := "sbt-guardrail-java-codegen-example"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.3"

scalacOptions += "-Xexperimental"

guardrailTasks in Compile := List(
  JavaClient(file("petstore.json"), pkg="com.example.clients.petstore"),
  JavaServer(file("petstore.json"), pkg="com.example.servers.petstore")
)

// workaround for SBT issue
unmanagedSourceDirectories in Compile += (sourceManaged in Compile).value

val dropwizardVersion = "2.0.15"

libraryDependencies ++= Seq(
  "io.dropwizard"                % "dropwizard-core"         % dropwizardVersion,
  "org.asynchttpclient"          % "async-http-client"       % "2.12.1",
  "org.glassfish.jersey.media"   % "jersey-media-multipart"  % "2.32",
  "javax.xml.bind"               % "jaxb-api"                % "2.3.1",
  "org.scalatest"               %% "scalatest"               % "3.2.2" % "test"
)

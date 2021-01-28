
enablePlugins(GuardrailPlugin)

name := "sbt-guardrail-java-codegen-example"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.4"

scalacOptions += "-Xexperimental"

guardrailTasks in Compile := List(
  JavaClient(file("petstore.json"), pkg="com.example.clients.petstore"),
  JavaServer(file("petstore.json"), pkg="com.example.servers.petstore")
)

// workaround for SBT issue
unmanagedSourceDirectories in Compile += (sourceManaged in Compile).value

val dropwizardVersion = "1.3.29"

libraryDependencies ++= Seq(
  "io.dropwizard"                % "dropwizard-core"         % dropwizardVersion,
  "org.asynchttpclient"          % "async-http-client"       % "2.12.2",
  "org.glassfish.jersey.media"   % "jersey-media-multipart"  % "3.0.1",
  "javax.xml.bind"               % "jaxb-api"                % "2.3.1",
  "org.scalatest"               %% "scalatest"               % "3.2.3" % "test"
)

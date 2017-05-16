organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"

  val jbossVersion = "3.5.6-Final"
  val springVersion = "3.0.5.RELEASE"
  val jbossRep = "JBoss repository" at "http://repository.jboss.org/nexus/content/groups/public-jboss/"

  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-json" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",

    "com.google.inject" % "guice" % "3.0",

    "com.google.inject.extensions" % "guice-persist" % "3.0",

    "org.hibernate" % "hibernate-core" % jbossVersion,
    "org.hibernate" % "hibernate-entitymanager" % jbossVersion,
    "org.hibernate" % "hibernate-validator" % "4.1.0.Final",
    "javax.validation" % "validation-api" % "1.0.0.GA",


    "org.slf4j" % "slf4j-api" % "1.6.1",
    "org.slf4j" % "slf4j-log4j12" % "1.6.1",
    "log4j" % "log4j" % "1.2.16",

    "hsqldb" % "hsqldb" % "1.8.0.7"
  )

}

Revolver.settings

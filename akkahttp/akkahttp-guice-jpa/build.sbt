organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies ++= {
  val AkkaVersion       = "2.4.18"
  val AkkaHttpVersion   = "2.4.11.2"
  Seq(
    "com.typesafe.akka" %% "akka-slf4j"      % AkkaVersion,
    "com.typesafe.akka" %% "akka-http-experimental" % AkkaHttpVersion,
    "ch.qos.logback"    %  "logback-classic" % "1.1.2",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.4"
  )
}

libraryDependencies ++= {
  val jbossVersion = "3.5.6-Final"
  val springVersion = "3.0.5.RELEASE"
  val jbossRep = "JBoss repository" at "http://repository.jboss.org/nexus/content/groups/public-jboss/"

  Seq(
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

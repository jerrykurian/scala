package com.app

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.http.scaladsl.Http
import akka.pattern.ask
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.app.modules.jpa.JpaInitializer
import com.app.modules.{AppService, Service, ServiceModule}
import com.app.services.NodeService
import com.google.inject.Guice
import com.google.inject.persist.jpa.JpaPersistModule
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._

object Boot extends App {

  val config = ConfigFactory.load()
  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("app-system")
  val injector = Guice.createInjector(new ServiceModule, new JpaPersistModule("JpaAkkaHttp"))
  implicit val materializer = ActorMaterializer()


  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(10 seconds)
  // Initialize the JPA Service
  injector.getInstance(classOf[JpaInitializer])

  // create and start our service actor
  println("Getting the App Service")
  val service = injector.getInstance(classOf[AppService])
  // start a new HTTP server on port 8080 with our service actor as the handler
  println(s"Found routes ${service.routes}")
  Http().bindAndHandle(handler = service.routes, interface = host, port = port) map { binding =>
    println(s"REST interface bound to ${binding.localAddress}") } recover { case ex =>
    println(s"REST interface could not bind to $host:$port", ex.getMessage)
  }

}

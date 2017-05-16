package com.app

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import com.app.modules.{AppService, Service, ServiceModule}
import com.app.services.NodeService
import com.google.inject.Guice

import scala.concurrent.duration._

object Boot extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("app-system")
  val injector = Guice.createInjector(new ServiceModule)
  // create and start our service actor
  val service = system.actorOf(Props(injector.getInstance(classOf[AppService])), "app-service")

  implicit val timeout = Timeout(5.seconds)
  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)

}

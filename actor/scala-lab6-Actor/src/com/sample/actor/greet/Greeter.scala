package com.sample.actor.greet

import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern._
import scala.concurrent.duration._
import akka.util.Timeout
import scala.concurrent.Await

object Greeter extends App{
  val system = ActorSystem("TestSystem")
  val greeter = system.actorOf(Props[GreetingActor],"greeter")
  implicit val timeout = Timeout(3 seconds)
  
  val futureResponse = greeter ? Greeting("Cisco")
  
  val result = Await.result(futureResponse, 3 seconds)
  println(result)
}
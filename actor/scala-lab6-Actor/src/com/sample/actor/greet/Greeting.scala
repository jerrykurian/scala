package com.sample.actor.greet

import akka.actor._
import akka.actor.ActorLogging

case class Greeting(who:String)

class GreetingActor extends Actor with ActorLogging{
  def receive = {
    case Greeting(who)=>{
      log.info("Hello {}",who)
      sender ! s"Hi ${who}"
    }
  }
}


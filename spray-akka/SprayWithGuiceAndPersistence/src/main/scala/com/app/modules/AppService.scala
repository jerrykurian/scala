package com.app.modules

import javax.inject.Inject

import akka.actor.Actor
import com.app.services.{CycleService, NodeService}
import spray.routing.{HttpService, Route}

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class AppService @Inject()(val nodeService:NodeService,
                           val cycleService: CycleService
                          )
  extends Actor with HttpService with RouteHolder with ApplicationExceptionHandler{
  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(nodeService.routes ~ cycleService.routes)

}

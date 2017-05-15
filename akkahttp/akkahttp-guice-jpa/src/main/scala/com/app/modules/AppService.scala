package com.app.modules

import javax.inject.Inject

import com.app.services.{CycleService, NodeService}
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class AppService @Inject()(val nodeService:NodeService,
                           val cycleService: CycleService
                          )
  extends ApplicationExceptionHandler{
  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def routes = nodeService.routes ~ cycleService.routes
 }

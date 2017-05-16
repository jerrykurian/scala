package com.app.modules

import spray.routing._
import spray.routing.HttpService._

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
trait RouteHolder {
  val routes:Route = null

  def addRoute(route:Route): Unit ={
    routes ~ route
  }
}

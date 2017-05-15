package com.app.modules
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
/**
  * Created by Jerry Kurian on 13-05-2017.
  */
trait RouteHolder {
  var allRoutes:Route = null
  def routes = allRoutes
  def addRoute(route:Route): Unit ={
    println(s"Adding route ${route}")
    allRoutes ~ route
  }
}

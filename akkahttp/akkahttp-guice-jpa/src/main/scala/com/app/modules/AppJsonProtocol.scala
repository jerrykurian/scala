package com.app.modules

import com.app.dto.{Cycle, Node}
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

/**
  * Created by Jerry Kurian on 11-05-2017.
  */
trait AppJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val nodeFormat = jsonFormat5(Node)
  implicit val cycleFormat = jsonFormat2(Cycle)
}


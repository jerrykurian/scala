package com.app.services

import com.app.domain.Node
import spray.http.{ContentType, MediaType}
import spray.http.MediaTypes.`application/json`
import spray.routing.HttpService

import spray.httpx.SprayJsonSupport._
import com.app.domain.AppJsonProtocol._

/**
  * Created by Jerry Kurian on 11-05-2017.
  */
trait NodeService extends HttpService{

  val nodes =  get {
    path("node") {
      respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          List(Node(1L, "12", "123", "3231231", "321321312"),Node(1L, "12", "123", "3231231", "321321312"))
        }
      }
    }
  }

  val node =  get {
    path("node" / IntNumber) { index =>
      respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          Node(1L, "12", "123", "3231231", "321321312")
        }
      }
    }
  }

  val save = post {
    path("node") {
      entity(as[Node]) {
        node => {
          complete {
            s"Added Node : ${node.name}"
          }
        }
      }
    }
  }
  val nodeRoutes = node ~ nodes ~ save
}

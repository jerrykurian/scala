package com.app.services

import javax.inject.Inject

import com.app.domain.Node
import com.app.modules.Service
import com.app.repository.NodeRepository
import spray.http.MediaTypes.`application/json`
import spray.httpx.SprayJsonSupport._
import spray.routing.HttpService._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class NodeService @Inject()(val nodeRepository: NodeRepository) extends Service {
  val nodes =  get {
    path("node") {
      respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          println("Called GET Node")
          nodeRepository.findAll()
        }
      }
    }
  }

  val node =  get {
    path("node" / IntNumber) { index =>
      respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          println("Called GET Node/Index")
          nodeRepository.find(index)
        }
      }
    }
  }

  val save = post {
    path("node") {
      entity(as[Node]) {
        node => {
          complete {
            println("Called POST Node")
            nodeRepository.save(node)
            s"Added Node : ${node.name}"
          }
        }
      }
    }
  }
  def routes = node ~ nodes ~ save
}


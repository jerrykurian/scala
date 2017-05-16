package com.app.services

import javax.inject.Inject

import com.app.domain.Cycle
import com.app.modules.Service
import com.app.repository.{CycleRepository}
import spray.http.MediaTypes.`application/json`
import spray.httpx.SprayJsonSupport._
import spray.routing.HttpService._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class CycleService @Inject()(val cycleRepository: CycleRepository) extends Service {
  val cycles =  get {
    path("cycle") {
      respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          println("Called GET Node")
          cycleRepository.findAll()
        }
      }
    }
  }

  val cycle =  get {
    path("cycle" / IntNumber) { index =>
      respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          println("Called GET Node/Index")
          cycleRepository.find(index)
        }
      }
    }
  }

  val save = post {
    path("cycle") {
      entity(as[Cycle]) {
        cycle => {
          complete {
            println("Called POST Node")
            cycleRepository.save(cycle)
            s"Added Node : ${cycle.number}"
          }
        }
      }
    }
  }
  def routes = cycle ~ cycles ~ save
}


package com.app.services

import javax.inject.Inject

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
          println("Called GET cycle")
          dtoTransformer(cycleRepository.findAll())
        }
      }
    }
  }

  val cycle =  get {
    path("cycle" / IntNumber) { index =>
      respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          println("Called GET cycle/Index")
          convertDomain(cycleRepository.find(index))
        }
      }
    }
  }

  val save = post {
    path("cycle") {
      entity(as[com.app.dto.Cycle]) {
        cycle => {
          complete {
            println("Called POST cycle")
            cycleRepository.save(convertDto(cycle))
            s"Added Cycle : ${cycle.number}"
          }
        }
      }
    }
  }

  def dtoTransformer(cycles:List[com.app.domain.Cycle]):List[com.app.dto.Cycle]={
    cycles.map((cycle:com.app.domain.Cycle) => convertDomain(cycle)): List[com.app.dto.Cycle]
  }

  def convertDto(cycle : com.app.dto.Cycle) : com.app.domain.Cycle = {
    val returnCycle = new com.app.domain.Cycle
    returnCycle.id = cycle.id
    returnCycle.number = cycle.number
    returnCycle
  }

  def convertDomain(cycle : com.app.domain.Cycle) : com.app.dto.Cycle = {
    com.app.dto.Cycle(cycle.id, cycle.number)
  }

  def routes = cycle ~ cycles ~ save
}


package com.app.services

import javax.inject.Inject

import akka.http.scaladsl.marshalling.ToResponseMarshallable
import com.app.modules.Service
import com.app.repository.NodeRepository
import akka.http.scaladsl.server.{Directives, Route}

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class NodeService @Inject()(val nodeRepository: NodeRepository) extends Service {
  val nodes =  get {
    path("node") {
      //respondWithMediaType(`application/json`) {
        complete {dtoTransformer(nodeRepository.findAll())}
      //}
    }
  }

  val node =  get {
    path("node" / IntNumber) { index =>
      //respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
        complete {
          println("Called GET Node/Index")
          ToResponseMarshallable(convertDomain(nodeRepository.find(index)))
        }
      //}
    }
  }

  val save = post {
    path("node") {
      entity(as[com.app.dto.Node]) {
        node => {
          complete {
            println("Called POST Node")
            nodeRepository.save(convertDto(node))
            s"Added Node : ${node.name}"
          }
        }
      }
    }
  }

  def dtoTransformer(nodes:List[com.app.domain.Node])={
    val dtoNodes = nodes.map((node:com.app.domain.Node) => convertDomain(node)): List[com.app.dto.Node]
    ToResponseMarshallable(dtoNodes)
  }

  def convertDto(node : com.app.dto.Node) : com.app.domain.Node = {
    val returnNode = new com.app.domain.Node
    returnNode.id = node.id
    returnNode.name = node.name
    returnNode.address = node.address
    returnNode.latitude = node.latitude
    returnNode.longitude = node.longitude
    returnNode
  }

  def convertDomain(node : com.app.domain.Node)= {
    com.app.dto.Node(node.id, node.name,node.address,node.latitude,node.longitude)
  }

  def routes = node ~ nodes ~ save
}


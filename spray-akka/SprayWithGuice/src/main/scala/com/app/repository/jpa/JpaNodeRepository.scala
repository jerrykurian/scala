package com.app.repository.jpa

import com.app.domain.Node
import com.app.repository.NodeRepository

import scala.collection.mutable.ListBuffer

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class JpaNodeRepository extends NodeRepository{
  var nodes = ListBuffer(Node(1L, "12", "123", "3231231", "321321312"),Node(1L, "13", "123", "3231231", "321321312"))
  def save(node:Node): Unit = {
    nodes += node
  }

  def findAll: List[Node] = {
    nodes.toList
  }

  def find(index:Int): Node = {
    nodes.toList(index)
  }
}

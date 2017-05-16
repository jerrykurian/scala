package com.app.repository

import com.app.domain.Node

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
trait NodeRepository {
  def save(node:Node):Unit
  def findAll():List[Node]
  def find(id:Int):Node
}
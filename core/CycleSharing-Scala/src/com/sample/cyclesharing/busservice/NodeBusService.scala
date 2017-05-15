package com.sample.cyclesharing.busservice

import com.sample.cyclesharing.model.Node

trait NodeBusService {
  
  def nodes(state:String):List[Node]
  def save(node:Node)
  def findAll:List[Node]
  def findById(int:Int):Node
  
}
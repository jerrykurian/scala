package com.sample.cyclesharing.busservice.impl

import com.sample.cyclesharing.busservice.NodeBusService
import com.sample.cyclesharing.busservice.DataConverter
import com.sample.cyclesharing.model.Node

class NodeBusServiceImpl extends NodeBusService with DataConverter{
  var nodesStorage = List.newBuilder[Node]
  
  def nodes(state:String):List[Node]={
    nodesStorage.result().filter { node:Node => node.state.equals(state) }
  }
  def save(node:Node){nodesStorage+=node}
  def findAll=nodesStorage.result()  
 
}
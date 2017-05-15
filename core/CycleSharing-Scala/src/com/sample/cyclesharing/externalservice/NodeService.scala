package com.sample.cyclesharing.externalservice

import com.sample.cyclesharing.model.Node
import com.sample.cyclesharing.busservice.impl.NodeBusServiceImpl
import com.sample.cyclesharing.busservice.NodeBusService
import com.sample.cyclesharing.model.StringConverter

object NodeService extends StringConverter{
  val nodeService:NodeBusService = new NodeBusServiceImpl
  def save(node:Node){
    nodeService.save(node)
  }
  
  def findNode(id:Int):String={
    nodeService.findById(1)
  }
}
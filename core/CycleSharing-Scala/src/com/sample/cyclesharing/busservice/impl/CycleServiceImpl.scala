package com.sample.cyclesharing.busservice.impl

import com.sample.cyclesharing.externalservice.CycleService
import com.sample.cyclesharing.model.Cycle
import com.sample.cyclesharing.model.Node
import com.sample.cyclesharing.busservice.StateToggler

class CycleServiceImpl extends CycleService with StateToggler{
  def returnCycle(cycle:Cycle, node:Node){
    val changedCycle = toggle(cycle=>{cycle}) 
    
  }
}
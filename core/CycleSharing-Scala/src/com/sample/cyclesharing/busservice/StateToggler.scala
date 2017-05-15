package com.sample.cyclesharing.busservice

import com.sample.cyclesharing.model.Cycle

trait StateToggler {
  def toggle( x:Cycle=> Cycle)
  
  def makeFree(cycle:Cycle)={
    val newCycle = cycle.copy(free=true, inUse=false)
    newCycle
  }

  def markInUse(cycle:Cycle)={
    val newCycle = cycle.copy(free=false, inUse=true)
    newCycle
  }

}
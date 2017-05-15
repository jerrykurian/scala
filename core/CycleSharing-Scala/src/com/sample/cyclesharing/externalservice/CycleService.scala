package com.sample.cyclesharing.externalservice

import com.sample.cyclesharing.model.Cycle
import com.sample.cyclesharing.model.Node

trait CycleService {
  def returnCycle(cycle:Cycle, node:Node)
}
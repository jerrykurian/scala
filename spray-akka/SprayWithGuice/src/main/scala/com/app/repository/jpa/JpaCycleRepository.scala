package com.app.repository.jpa

import com.app.domain.{Cycle}
import com.app.repository.{CycleRepository}

import scala.collection.mutable.ListBuffer

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class JpaCycleRepository extends CycleRepository{
  var cyles = ListBuffer(Cycle(1L, "321321312"),Cycle(2L, "321321312"))
  def save(cycle:Cycle): Unit = {
    cyles += cycle
  }

  def findAll: List[Cycle] = {
    cyles.toList
  }

  def find(index:Int): Cycle = {
    cyles.toList(index)
  }
}

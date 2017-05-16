package com.app.repository

import com.app.domain.{Cycle}

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
trait CycleRepository {
  def save(cycle:Cycle):Unit
  def findAll():List[Cycle]
  def find(id:Int):Cycle
}
package com.training.scala.model

trait Recordable {
  var checkedInTime=0L
  def checkIn(time:Long){
    println("Called checkin on Recordable")
    checkedInTime = time
  }
  
  def checkOut(time:Long)
}
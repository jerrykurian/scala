package com.training.scala.model

case class Employee(val empId:String, override val firstName:String, override val lastName:String) 
  extends Person(firstName,lastName) with Recordable with Privileged{
  
  def checkOut(time:Long){
    println("Check in happened at " + checkedInTime)
    println("Checking out Employee")
  }
}
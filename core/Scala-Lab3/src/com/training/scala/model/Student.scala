package com.training.scala.model

case class Student(val rollNo:String, override val firstName:String, override val lastName:String) 
  extends Person(firstName,lastName) with Recordable {
    def this(rollNo:String)=this(rollNo,"","")
    
    /*override def checkIn(time:Long){
      // 
      println("Called checkin on Student")
    }*/
    override def checkOut(time:Long){
      println("Check in happened at " + checkedInTime)
      println("Checking out Student")
    }
}
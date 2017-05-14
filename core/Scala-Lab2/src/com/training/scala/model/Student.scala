package com.training.scala.model

case class Student(val rollNo:String, override val firstName:String, override val lastName:String) 
  extends Person(firstName,lastName) {
    def this(rollNo:String)=this(rollNo,"","")
}
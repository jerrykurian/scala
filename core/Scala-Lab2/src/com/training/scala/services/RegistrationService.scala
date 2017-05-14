package com.training.scala.services

import com.training.scala.model.Person
import com.training.scala.model.Student

class RegistrationService {
    
  def registerStudent(rollNo:String,firstName:String,lastName:String){
     
    val person1 = new Student("20",firstName,lastName)
    val person2:Person = new Student("20",firstName,lastName)
    val person3 = new Student("22",firstName,lastName)
    
    println("Person 3 roll no is " + person2.asInstanceOf[Student].rollNo)

    if(person1==person2)
      println("Equal")
    else
      println("Not Equal")
      
    if(person1==person3)
      println("Equal")
    else
      println("Not Equal")
  }
}
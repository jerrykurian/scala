package com.training.scala.services

import com.training.scala.model.Person

class RegistrationService {
    
   def register(firstName:String,lastName:String){
     
    val updatedFirstName = firstName + "Update"
    val person1 = new Person(firstName,lastName)
    //println("First User First Name is " + person1.firstName)
    //println(person1.lastName)

    val person2:Person = new Person(firstName,lastName)
    val person3 = new Person(firstName,lastName)
    
    println("Person 2 firstName is " + person2.firstName)

    if(person1==person2)
      println("Equal")
    else
      println("Not Equal")
      
    if(person1==person3)
      println("Equal")
    else
      println("Not Equal")
    //println(person2.lastName)
    
    // Save to the database
  }
    
}
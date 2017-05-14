package com.training.scala.services

import com.training.scala.model.Recordable
import com.training.scala.model.Student
import com.training.scala.model.Recordable
import com.training.scala.model.Employee
import com.training.scala.model.Person

object TimeTrackingService {
  def trackTimeOfStudent(studentRollNo:String){
    // Get the student with Role No
    val student = new Student(studentRollNo)
    student.checkIn(System.currentTimeMillis())
    
    student.checkOut(System.currentTimeMillis())
  }
  
  def trackTimeOfPerson(firstName:String){
    // Get the student with Role No
    val person:Recordable = getSpecificPerson(firstName)// Get the person 
    val person1:Person = getSpecificPerson(firstName)
    person.checkIn(System.currentTimeMillis())
   
    person.checkOut(System.currentTimeMillis())
  }
  
  private def getSpecificPerson(firstName:String)={
    if(firstName.startsWith("S")){
      val nameData = getFNameLName
      val (fName, lName) = getFNameLName
      Student("",fName,lName)
    }else{
      Employee("",firstName,"")
    }
  }
  
  private def getFNameLName:(String,String)=("User FName","User LName")
  
}
















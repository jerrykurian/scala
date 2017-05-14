package com.training.scala.model

case class TempEmployee(val tempId:String, override val firstName:String, override val lastName:String) 
  extends Person(firstName,lastName) {
}
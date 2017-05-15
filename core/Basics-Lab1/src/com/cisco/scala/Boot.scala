package com.cisco.scala

object Boot {
  def main(args : Array[String]){
    println("Hello World")
  }
  
  val firstList = List(1,2,3,4)
  
  val secondList = 5 :: firstList
  
  println(firstList.head)
  println(secondList.head)
  
  val thirdList = firstList ::: secondList
  println(thirdList.head)
  println(firstList.head)
  println(secondList.head)
  
  val result = for(i <- firstList) yield {
    println(s"Printing ${i}") // If this is the last statement then this will yield a list of Unit List[Unit]
    2*i
  }
  println(s"Result is ${result}")
  
  val personDetails = returnPersonAtCity("Bangalore")
  println(personDetails._1)
  println(personDetails._2)
  
  def returnPersonAtCity(city:String)=("First Name","Last Name")
  
  
  
}
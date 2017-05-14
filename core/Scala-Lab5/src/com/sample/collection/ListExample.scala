package com.sample.collection

object ListExample extends App {
  val numbers = List(1,2,3,4,5)
  
  //numbers.map { x => x+1 }.map { x => performOperation(x) }
  numbers.filter { x => x%2==0 }.foreach { x => performOperation(x) }
  def performOperation(x:Int){
    println(x)
  }
  
  val fruits = List("Apple","Orange", "Apple1","Pear")
  val data = fruits groupBy{ _.head }
  println(data) 
}
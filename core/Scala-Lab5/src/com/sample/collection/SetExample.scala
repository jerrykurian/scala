package com.sample.collection

object SetExample extends App{
  
  val numberSet = Set(1,1,3,4,5,5)
  val  userSet = Set(User(1,"User1"),User(2,"User1"),
      User(1,"User1"))
  
  numberSet.foreach { x => println(x) }
  userSet.foreach { x => println(x) }
}
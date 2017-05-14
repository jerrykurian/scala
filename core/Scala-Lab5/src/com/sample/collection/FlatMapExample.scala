package com.sample.collection

object FlatMapExample extends App {
  
  returnNumbers
  
  
  def returnNumbers={
    val users = List(1,2,3,4)
    users.map {
      x => returnAllUsefulNumbers 
      }
    .flatMap{
      y=>y
      }
    .map { z => println(z) }
  }
  
  def returnAllUsefulNumbers={
    val users = List(1,2,3,4)
    users
  }
}
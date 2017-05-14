package com.example.functional

object ClosureUser extends App {
  ClosureClass.setGreeting("Welcome ")
  sayMessage(ClosureClass.sayGreeting, "World")
  def sayMessage(f:String=>Unit, name:String){
    f(name)
  }
}

object ClosureClass{
  var hello = "Hello "
  
  def setGreeting(data:String){
    hello = data;
  }
  
  def sayGreeting(data:String){
    println(hello + data);
  }
  
}
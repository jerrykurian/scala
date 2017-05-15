package com.cisco.scala

object FunctionalBoot {
  def main(args : Array[String]){
    println("Hello World")
  }
  
  val twoMultiplier = (x:Int)=>{
    if(x>0){
      x*2
    }else{
      0
    }
    
  }
  
  println(s"3 * 2 is ${twoMultiplier(3)}")
}
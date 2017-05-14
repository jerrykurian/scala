package com.example.functional
import com.example.library._
object FunctionalExample extends App {
  
  val word = "Hello1 World ..."
  val numbers = List(1,2,3,4,5,6,7,8,9,0)
  val reducedNumber = numbers.reduce((a,b)=>{
    println(a + ":" + b)
    a+b
  })
  println("Reduced Number " + reducedNumber)
  val uniqueNumbers = Set(1,1,1,3,4,3)
  
  def countChars(charToBeCounted:Char)={
    charToBeCounted.isLetter
  }
  
  //println(word.count(countChars))
  //println(word.filter{c=>c=='l'})
  
  //filterData(word, {c=>c.isLetter})
  def filterData(data:String, p:Char=>Boolean){
    data.foreach { x => {
        if(p(x)){
          print(x) 
        }
      }
    }
    println()
  }
  
  def filterNumbers(data:List[Int], f:Int=>Boolean){
    data.foreach { x => if(f(x))println(x) }
  }
  
  //println(comparator(10,20, {(data1:Int,data2:Int)=>data1>data2}))
  
  def comparator(data1:Int, data2:Int, f:(Int,Int)=>Boolean)={
    f(data1,data2)
  }
  
  println("Total elements in set is " + uniqueNumbers.count { x => true })
}








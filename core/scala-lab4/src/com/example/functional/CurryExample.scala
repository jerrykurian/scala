package com.example.functional

object CurryExample extends App {
    
  val numbers = List(1,2,3,4,5,6,7,8,9,0)
  
  val foldR = numbers.foldRight[Int](0)_
  println(foldR{
    (data:Int,default:Int)=>{
      println(default)
      data+default
      }
     })
  println(numbers.foldLeft[Int](0){
    (data:Int,default:Int)=>{
      println(data)
      data+default
      }
     })
  compareListElements(20,numbers)
  def compareListElements(data:Int,dataList:List[Int]){
    val comparer = compareTwo(data)_
    dataList.foreach { x => {
        comparer(x)
      }
    }
  }
  
  def compareTwo(default:Int)(current:Int)={
    println("Comparing between " + default + " and current " + current)
    default>current
  }

}
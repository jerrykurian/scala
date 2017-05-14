package com.sample.collection

object OptionExample extends App{
  
  var user = findByUserId(10) 
  user match {
    case Some(u)=>actOnUser(u)
    case None=>println("Got Nothing")
  }
  
  printUser(user)
  user = findByUserId(11)
  printUser(user)
  
  findByUserId(10).map { x => println(x.id) }
  
  def printUser(userData:Option[User]){
    userData match {
      case Some(u)=>println(u.id)
      case None=>println("Got Nothing")
    }  
  }
  
  def findByUserId(id:Long):Option[User]={
    if(id==10){
      Some(User(10,"first"))
    }else{
      None
    }
  }
  
  def actOnUser(user:User){
    
  }
}
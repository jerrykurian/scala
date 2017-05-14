package com.sample.collection

object MapExample extends App{
  val dict = Map("123"->"User1", "234"->"User2")
  println(dict("123"))
  println(dict("234"))
}
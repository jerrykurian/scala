package com.sample.cyclesharing.busservice

trait DataConverter {
  def convert(value:Int):String={
    value.toString()
  }
}
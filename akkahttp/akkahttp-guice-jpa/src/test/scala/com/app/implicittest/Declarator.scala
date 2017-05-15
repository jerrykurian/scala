package com.app.implicittest

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
trait Declarator {
  implicit def converter(a:A):B={
    B(a.id)
  }
}

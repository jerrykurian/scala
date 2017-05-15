package com.app.domain

import javax.persistence._

import scala.beans.BeanProperty

/**
  * Created by Jerry Kurian on 11-05-2017.
  */
@Entity
@Table
case class Cycle() {
  @Id @GeneratedValue(strategy = GenerationType.AUTO) @BeanProperty
  var id:Long = _
  @BeanProperty
  var number:String = _
}

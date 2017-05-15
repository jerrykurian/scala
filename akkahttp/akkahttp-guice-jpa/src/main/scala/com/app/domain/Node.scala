package com.app.domain

import javax.persistence._

import scala.beans.BeanProperty

/**
  * Created by Jerry Kurian on 11-05-2017.
  */
@Entity
@Table
case class Node() {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id:Long = _
  @BeanProperty
  var name = ""
  @BeanProperty
  var address = ""
  @BeanProperty
  var latitude = ""
  @BeanProperty
  var longitude = ""
}

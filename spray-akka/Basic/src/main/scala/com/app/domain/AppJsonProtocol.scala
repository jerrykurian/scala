package com.app.domain

import spray.json.DefaultJsonProtocol

/**
  * Created by Jerry Kurian on 11-05-2017.
  */
object AppJsonProtocol extends DefaultJsonProtocol {
  implicit val nodeFormat = jsonFormat5(Node)
}

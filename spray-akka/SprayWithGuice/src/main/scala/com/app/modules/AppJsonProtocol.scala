package com.app.modules

import com.app.domain.{Cycle, Node}
import spray.json.DefaultJsonProtocol

/**
  * Created by Jerry Kurian on 11-05-2017.
  */
trait AppJsonProtocol extends DefaultJsonProtocol {
  implicit val nodeFormat = jsonFormat5(Node)
  implicit val cycleFormat = jsonFormat2(Cycle)
}

package com.app.modules

import spray.routing.Route

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
trait Service extends AppJsonProtocol{
  def routes:Route
}

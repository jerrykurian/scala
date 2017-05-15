package com.app.modules

import akka.http.scaladsl.server.{Directives, Route}

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
trait Service extends Directives with AppJsonProtocol{
  def routes:Route
}

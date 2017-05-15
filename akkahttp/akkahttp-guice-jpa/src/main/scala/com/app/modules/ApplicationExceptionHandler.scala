package com.app.modules

import akka.event.LoggingAdapter
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.ExceptionHandler
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

/**
  * Created by Jerry Kurian on 14-05-2017.
  */
trait ApplicationExceptionHandler {
  implicit def exceptionHandler(implicit log:LoggingAdapter)=
  ExceptionHandler{
    case e: Exception =>
        log.warning("Request to could not be handled normally")
        complete(StatusCodes.BadRequest, "Bad numbers, bad result!!!")
  }
}

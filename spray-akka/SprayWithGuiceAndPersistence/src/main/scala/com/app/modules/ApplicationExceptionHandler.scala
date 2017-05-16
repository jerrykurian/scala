package com.app.modules

import spray.http.StatusCodes._
import spray.routing.ExceptionHandler
import spray.routing.HttpService._
import spray.util.LoggingContext

/**
  * Created by Jerry Kurian on 14-05-2017.
  */
trait ApplicationExceptionHandler {
  implicit def exceptionHandler(implicit log:LoggingContext)=
  ExceptionHandler{
    case e: Exception =>
      requestUri { uri =>
        log.warning("Request to {} could not be handled normally", uri)
        complete(InternalServerError, "Bad numbers, bad result!!!")
      }
  }
}

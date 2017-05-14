package com.training.scala.test

import com.training.scala.services.RegistrationService

object TestLab1 extends App {
     new RegistrationService().register("Test", "User")
}
package com.training.scala.test

import com.training.scala.services.RegistrationService
import com.training.scala.services.TimeTrackingService

object TestLab1 extends App {
     TimeTrackingService.trackTimeOfStudent("20")
     TimeTrackingService.trackTimeOfPerson("Student")
     TimeTrackingService.trackTimeOfPerson("Employee")
}
package com.app.modules.jpa

import javax.inject.Inject

import com.google.inject.persist.PersistService

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class JpaInitializer @Inject()(service:PersistService){
  service.start()
}

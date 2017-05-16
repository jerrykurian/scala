package com.app.modules

import com.app.services.NodeService
import com.google.inject.AbstractModule

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class ServiceModule extends AbstractModule{
  override def configure(): Unit = {
    bind(classOf[NodeService]).to
  }
}

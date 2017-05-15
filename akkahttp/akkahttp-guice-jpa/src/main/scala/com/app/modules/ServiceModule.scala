package com.app.modules

import com.app.repository.{CycleRepository, NodeRepository}
import com.app.repository.jpa.{JpaCycleRepository, JpaNodeRepository}
import com.app.services.{CycleService, NodeService}
import com.google.inject.AbstractModule

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class ServiceModule extends AbstractModule{
  override def configure(): Unit = {
    bind(classOf[AppService])
    bind(classOf[NodeService])
    bind(classOf[CycleService])
    bind(classOf[NodeRepository]).to(classOf[JpaNodeRepository])
    bind(classOf[CycleRepository]).to(classOf[JpaCycleRepository])
  }
}

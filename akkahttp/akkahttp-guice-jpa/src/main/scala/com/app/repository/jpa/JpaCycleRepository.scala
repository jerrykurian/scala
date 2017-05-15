package com.app.repository.jpa

import javax.inject.Inject
import javax.persistence.EntityManager

import com.app.domain.Cycle
import com.app.repository.CycleRepository
import com.google.inject.persist.Transactional

import scala.collection.JavaConverters._

/**
  * Created by Jerry Kurian on 13-05-2017.
  */
class JpaCycleRepository @Inject()(em:EntityManager) extends CycleRepository{
  @Transactional
  def save(cycle:Cycle): Unit = {
    println(s"Saving using ${em}")
    em.getTransaction.begin()
    em.persist(cycle)
    em.getTransaction.commit()
  }

  def findAll: List[Cycle] = {
    em.createQuery("from Cycle").getResultList.asInstanceOf[java.util.List[Cycle]].asScala.toList
  }

  def find(index:Int): Cycle = {
    em.find(Cycle.getClass,index).asInstanceOf[Cycle]
  }
}

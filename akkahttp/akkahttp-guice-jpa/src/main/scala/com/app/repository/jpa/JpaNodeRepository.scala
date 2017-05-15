package com.app.repository.jpa

import javax.inject.Inject
import javax.persistence.EntityManager

import com.app.domain.Node
import com.app.repository.NodeRepository
import com.google.inject.persist.Transactional

import scala.collection.JavaConverters._

/**
  * Created by Jerry Kurian on 13-05-2017.
  */

class JpaNodeRepository @Inject()(em:EntityManager) extends NodeRepository{
  @Transactional
  def save(node: Node): Unit = {
    em.persist(node)
  }

  def findAll: List[Node] = {
    val nodes = em.createQuery("from Node").getResultList.asInstanceOf[java.util.List[Node]]
    nodes.asScala.toList
  }

  def find(index:Int): Node = {
    em.find(Node.getClass,index).asInstanceOf[Node]
  }
}


package com.sample.cyclesharing.model

trait StringConverter {
  implicit def convert(node:Node):String={
    return s"{id:${node.id}}"
  }
}
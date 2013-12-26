package cz.flih.relgraph

import com.tinkerpop.blueprints._
import java.lang.{Iterable => JIterable}

class SQLRGraph extends Graph {
  def addEdge(id: Any, outVertex: Vertex, inVertex: Vertex, label: String): Edge = ???

  def addVertex(id: Any): Vertex = ???

  def getEdge(id: Any): Edge = ???

  def getEdges(key: String, value: Any): JIterable[Edge] = ???

  def getEdges(): JIterable[Edge] = ???

  def getFeatures(): Features = ???

  def getVertex(id: Any): Vertex = ???

  def getVertices(key: String, value: Any): JIterable[Vertex] = ???

  def getVertices(): JIterable[Vertex] = ???

  def query(): GraphQuery = ???

  def removeEdge(edge: Edge): Unit = ???

  def removeVertex(vertex: Vertex): Unit = ???

  def shutdown(): Unit = ???
}

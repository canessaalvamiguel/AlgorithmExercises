package codility

import scala.collection.convert.ImplicitConversions.`map AsJavaMap`

object Dominator {
  def solution(a: Array[Int]): Int = {
    val counter: Map[Int, Int] = Map()
    for (element <- a) {
      counter.get(element) match {
        case Some(value) => counter.put(element, value + 1)
        case _ => counter.put(element, 1)
      }
    }
    val prom_leader: Int = a.size / 2
    var leader: Int = -1
    for (element <- counter) {
      if (element._2 > prom_leader)
        leader = element._1
    }
    a.indexOf(leader)
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(3, 0, 1, 1, 4, 1, 1)))
    println(solution(Array(1, 2, 3, 4, 5, 6, 7)))
  }
}

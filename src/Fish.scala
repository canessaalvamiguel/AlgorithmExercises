/*
Link problem: https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
*/

import scala.collection.mutable

object Fish {
  def solution(a: Array[Int], b: Array[Int]): Int = {
    val dowstream = mutable.Stack[Int]()
    var survivors = a.size
    for(i <- 0 to a.size - 1){
      if( b(i) == 1 ){
        dowstream.push(i)
      }else{
        var continue = true
        while(!dowstream.isEmpty & continue){
          if( a(i) > a(dowstream.head) ){
            dowstream.pop
            survivors-= 1
          }else{
            survivors-= 1
            continue = false
          }
        }
      }
    }
    survivors
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(4, 8, 2, 6, 7),Array(0, 1, 1, 0, 0)))
    println(solution(Array(4, 3, 2, 1, 5),Array(0, 1, 0, 0, 0)))
  }
}
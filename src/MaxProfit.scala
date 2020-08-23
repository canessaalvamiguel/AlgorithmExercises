/*
Link problem: https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
*/

object MaxProfit {
  def solution(a: Array[Int]): Int = {
    var maxLocalSum:Long = 0
    var maxGlobalSum:Long = 0
    for(i <- 1 to a.size - 1){
      val diff:Long = a(i) - a(i-1)
      maxLocalSum = Math.max( diff, maxLocalSum + diff )
      maxGlobalSum = Math.max( maxLocalSum, maxGlobalSum )
    }
    maxGlobalSum.toInt
  }

  def main(args: Array[String]): Unit = {
    //                            -2160,   112,   243,  -353,   354
    println(solution(Array(23171, 21011, 21123, 21366, 21013, 21367)))
  }
}
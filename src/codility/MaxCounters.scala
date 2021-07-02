package codility

object MaxCounters {
  def solution(n: Int, a: Array[Int]): Array[Int] = {
    val counters: Array[Int] = Array.fill[Int](n)(0);
    var currentMax: Int = 0;
    var startLine: Int = 0;
    var index = 0
    for (i <- 0 to a.size - 1) {
      index = a(i) - 1
      if (a(i) > n) {
        startLine = currentMax;
      } else if (counters(index) < startLine) {
        counters(index) = 1 + startLine
      } else
        counters(index) += 1;

      if (a(i) < n && counters(index) > currentMax) currentMax = counters(index);
    }
    for (i <- 0 to counters.size - 1) {
      if (counters(i) < startLine)
        counters(i) = startLine
    }
    counters
  }

  def main(args: Array[String]): Unit = {
    println(solution(5, Array(3, 4, 4, 6, 1, 4, 4)).mkString(", "))
  }
}

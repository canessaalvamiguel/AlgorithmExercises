package codility

object CyclicRotation {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    val finalData: Array[Int] = new Array[Int](a.size)
    for (i <- 0 to a.size - 1) {
      finalData((i + k) % a.size) = a(i)
    }
    finalData
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(7, 2, 8, 3, 5), 2).mkString(", "))
    println(solution(Array(7, 2, 8, 3, 5), 5).mkString(", "))
  }
}

package codility

object PermMissingElem {
  def solution(a: Array[Int]): Int = {
    val expectedSize: Long = a.size + 1
    val expectedSum: Long = (expectedSize * (expectedSize + 1)) / 2
    val arraySum: Long = a.foldLeft(0)(_ + _)
    (expectedSum - arraySum).toInt
  }

  def main(args: Array[String]): Unit = {
    println(solution(Array(2, 3, 1, 5)))
    println(solution(Array(1, 2, 3, 4, 5, 6, 7, 8, 9)))
    println(solution(Array()))
  }
}

package codility

object CountDiv {
  def solution(a: Int, b: Int, k: Int): Int = {
    val start: Double = (a.toDouble / k.toDouble).ceil
    val end: Double = (b.toDouble / k.toDouble).floor
    end.toInt - start.toInt + 1
  }

  def main(args: Array[String]): Unit = {
    println(solution(6, 11, 2))
  }
}

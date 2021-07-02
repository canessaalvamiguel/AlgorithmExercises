package codility

/*
* Link to problem: https://www.hackerrank.com/challenges/recursive-digit-sum/problem
* */
object RecursiveDigitSum {

  // Complete the superDigit function below.
  def superDigit(n: String, k: Int): Int = {
    solution((solution(n) * k).toString);
  }

  def solution(x: String): Int = {
    if (x.length == 1) x.toInt
    else {
      val sum: Long = x.map {
        _.asDigit
      }.foldLeft(0) {
        _ + _
      }
      solution(sum.toString)
    }
  }

  def main(args: Array[String]): Unit = {
    println(superDigit("148", 3))
    println(superDigit("148", 7))
  }
}

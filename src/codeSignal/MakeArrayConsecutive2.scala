package codeSignal

/***
 * https://app.codesignal.com/arcade/intro/level-2/bq2XnSr5kbHqpHGJC
 *
 * Ratiorg got statues of different sizes as a present from CodeMaster for his birthday,
 * each statue having an non-negative integer size. Since he likes to make things perfect,
 * he wants to arrange them from smallest to largest so that each statue will be bigger than
 * the previous one exactly by 1. He may need some additional statues to be able to accomplish that.
 *
 * Help him figure out the minimum number of additional statues needed.
 *
 * Example
 * For statues = [6, 2, 3, 8], the output should be
 * solution(statues) = 3.
 * Ratiorg needs statues of sizes 4, 5 and 7.
 */
object MakeArrayConsecutive2 extends App {

  val statues = Array(6, 2, 3, 8)
  val result : Int = solution(statues)
  println("Result : " + result)

  def solution(statues: Array[Int]): Int = {
    statues.max - statues.min - statues.length + 1;
  }
}

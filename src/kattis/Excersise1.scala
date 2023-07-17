package kattis

import scala.annotation.tailrec

object problemA {
  def main(args: Array[String]) {
    var line = scala.io.StdIn.readLine()
    while (line != "4") {//4 will generate a infinite loop
      val number = line.toInt
      val result = solve(number)
      Console.out.println(result.mkString(" "))
      line = scala.io.StdIn.readLine()
    }
  }

  @tailrec
  def solve(number: Int, times: Int = 1): List[Int] = {
    factorizeUsingPrimes(number) match {
      case x if(x.size == 1) => List(x.head, times)
      case x => solve(x.sum, times + 1)
    }
  }

  def factorizeUsingPrimes(x: Int): List[Int] = {
    @tailrec
    def factorize(x: Int, a: Int = 2, list: List[Int] = Nil): List[Int] = a * a > x match {
      case false if x % a == 0 => factorize(x / a, a, a :: list)
      case false => factorize(x, a + 1, list)
      case true => x :: list
    }

    factorize(x)
  }
}

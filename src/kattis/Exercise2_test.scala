package kattis

import scala.annotation.tailrec

object problemB_test {

  def main(args: Array[String]) {
        val line =
          """5
            |are yo
            |you u
            |how nhoware
            |alan arala
            |dear de
            |8
            |i ie
            |ing ding
            |resp orres
            |ond pon
            |oyc y
            |hello hi
            |enj njo
            |or c
            |3
            |efgh efgh
            |d cd
            |abc ab
            |3
            |a ab
            |b bb
            |c cc
            |""".stripMargin.replaceAll("\\R", "*")

//    val line =
//      """|1
//        |efgh efgh
//        """.stripMargin.replaceAll("\\R", "*")

    val result = solve(line)
    Console.out.print(result)
  }

  def solve(entry: String ): String = {
    val lines = entry.split('*').toList
    createCases(lines).mkString("\n")
  }

  def createCases(lines: List[String]): List[String] = {
    val indicators: List[Int] = lines.filter(_.matches("\\d+")).map(_.toInt)
    val linesF = lines.filterNot(_.matches("\\d+"))

    for {
      index <- indicators.indices.toList
      from = indicators.slice(0, index).sum
      to = from + indicators(index)
    } yield {
      process(linesF.slice(from, to), index + 1)
    }
  }

  def process(lines: List[String], index: Int): String = {
    val result = processFinal(lines.sorted.reverse)
    if(result.contains("IMPOSSIBLE") || result.isEmpty)
      "Case "+index+": IMPOSSIBLE"
    else "Case "+index+": "+result
  }

  @tailrec
  def processFinal(lines: List[String], concat1: StringBuilder = new StringBuilder(), concat2: StringBuilder = new StringBuilder(), pending: StringBuilder = new StringBuilder()): String = {

    if(lines.isEmpty)
      return concat1.toString

    val firstT = lines.foldLeft("") {
      (acc, element) => {
        val word = element.split(" ")
        val word_1 = word(0)
        val word_2 = word(1)
        val contrast1 = if(pending.isEmpty) word_2 else pending.toString
        val contrast2 = if(pending.isEmpty) word_1 else pending.toString
        val lookInLeft = concat2.length > concat1.length || pending.isEmpty
        val lookInRight = concat1.length > concat2.length || pending.isEmpty

        if (word_1.startsWith(contrast1) && !word_1.equals(word_2) && lookInLeft && acc.isEmpty) {
          word_1 + "$" + element + "$" + word_2
        } else if (word_2.startsWith(contrast2) && !word_1.equals(word_2) && lookInRight && acc.isEmpty) {
          word_1 + "$" + element + "$" + word_2
        } else {
          acc
        }
      }
    }

    if(firstT.isEmpty && !concat1.equals(concat2)){
      return "IMPOSSIBLE"
    }else if(firstT.isEmpty){
      return concat1.toString
    }

    val (word1, firstLineProcessed, word2, pendingWord) = {
      val aux = firstT.split("\\$")
      val pendingF = {
        val c1 = concat1 + aux(0)
        val c2 = concat2 + aux(2)
        if(c1.length > c2.length)
          c1.replaceFirst(c2, "")
        else
          c2.replaceFirst(c1, "")
      }
      (aux(0), aux(1), aux(2), new StringBuilder(pendingF))
    }
    val lines_remaining1 = lines.filterNot(_.contains(firstLineProcessed))

    println("lines: " + lines)
    println("firstT : " + firstT)
    println("remaining: " + lines_remaining1)
    println("pending : " + pendingWord)
    println("concat1 :" + concat1 + word1)
    println("concat2 :" + concat2 + word2)
    println()

    processFinal(lines_remaining1, concat1.append(word1), concat2.append(word2), pendingWord)

  }
}
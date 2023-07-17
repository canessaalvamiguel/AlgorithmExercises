package kattis

object problemB {

  def main(args: Array[String]) {

    var line = "*"
    var case_number = 1
    while (line != "") {
      line = scala.io.StdIn.readLine()

      if(line != null  && line.nonEmpty){
        var number = line.toInt
        var lineT: List[String] = List.empty
        while (number > 0) {
          lineT = lineT ++ List(scala.io.StdIn.readLine())
          number = number - 1
        }
        val result = solve(lineT, case_number)
        case_number = case_number + 1
        Console.out.println(result)
      }
    }
  }

  def solve(entry: List[String], case_number: Int): String = {
    createCases(entry, case_number)
  }

  def createCases(lines: List[String], case_number: Int): String = {
      process(lines, case_number)
  }

  def process(lines: List[String], index: Int): String = {
    println(lines)
    "Case " + index + ":"
  }


}

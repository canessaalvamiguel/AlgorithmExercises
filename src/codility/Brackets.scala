package codility

import scala.collection.mutable

object Brackets {
  def solution(s: String): Int = {
    val stack = mutable.Stack[Char]()
    for (element <- s) {
      if (element == '{' || element == '[' || element == '(')
        stack.push(element)
      else if (!stack.isEmpty && stack.head == '{' && element == '}')
        stack.pop
      else if (!stack.isEmpty && stack.head == '(' && element == ')')
        stack.pop
      else if (!stack.isEmpty && stack.head == '[' && element == ']')
        stack.pop
      else return 0
    }
    if (stack.isEmpty) 1 else 0
  }

  def main(args: Array[String]): Unit = {
    println(solution("()[]{}()[]{}"))
    println(solution("()]]"))
  }
}

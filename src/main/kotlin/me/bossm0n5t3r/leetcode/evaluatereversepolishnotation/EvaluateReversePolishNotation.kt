package me.bossm0n5t3r.leetcode.evaluatereversepolishnotation

class EvaluateReversePolishNotation {
    class Solution {
        fun evalRPN(tokens: Array<String>): Int {
            val stack = ArrayDeque<Int>()
            for (token in tokens) {
                when (token) {
                    "+" -> stack.doOperation { a, b -> a + b }
                    "-" -> stack.doOperation { a, b -> a - b }
                    "*" -> stack.doOperation { a, b -> a * b }
                    "/" -> stack.doOperation { a, b -> a / b }
                    else -> stack.addLast(token.toInt())
                }
            }
            return stack.removeLast()
        }

        private fun ArrayDeque<Int>.doOperation(operation: (Int, Int) -> Int) {
            val second = removeLast()
            val first = removeLast()
            addLast(operation(first, second))
        }
    }
}

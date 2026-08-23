package me.bossm0n5t3r.leetcode.evaluatereversepolishnotation

import java.util.Stack

class EvaluateReversePolishNotation {
    class Solution {
        fun evalRPN(tokens: Array<String>): Int {
            val stack = Stack<Int>()
            for (i in tokens.indices) {
                val token = tokens[i]
                if (token == "+" || token == "-" || token == "*" || token == "/") {
                    val b = stack.pop()
                    val a = stack.pop()
                    val result =
                        when (token) {
                            "+" -> a + b
                            "-" -> a - b
                            "*" -> a * b
                            "/" -> a / b
                            else -> error("Unexpected token: $token")
                        }
                    stack.push(result)
                    continue
                }
                stack.push(token.toInt())
            }
            return stack.peek()
        }
    }
}

package me.bossm0n5t3r.leetcode.scoreofparentheses

class ScoreOfParentheses {
    class Solution {
        fun scoreOfParentheses(s: String): Int {
            val stack = ArrayDeque<Int>()
            stack.addLast(0)
            for (c in s) {
                if (c == '(') {
                    stack.addLast(0)
                } else {
                    val inner = stack.removeLast()
                    val score = if (inner == 0) 1 else inner * 2

                    val outer = stack.removeLast()
                    stack.addLast(outer + score)
                }
            }
            return stack.last()
        }
    }
}

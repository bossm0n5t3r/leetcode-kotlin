package me.bossm0n5t3r.leetcode.reversesubstringsbetweeneachpairofparentheses

import java.util.Stack

class ReverseSubstringsBetweenEachPairOfParentheses {
    class Solution {
        fun reverseParentheses(s: String): String {
            val stack = Stack<Int>()
            val pair = mutableMapOf<Int, Int>()

            for (i in s.indices) {
                when (s[i]) {
                    '(' -> stack.push(i)
                    ')' -> {
                        val open = stack.pop()
                        pair[open] = i
                        pair[i] = open
                    }
                }
            }

            val result = StringBuilder()

            var index = 0
            var direction = 1

            while (index in s.indices) {
                if (index in pair) {
                    index = pair.getValue(index)
                    direction *= -1
                } else {
                    result.append(s[index])
                }

                index += direction
            }

            return result.toString()
        }
    }
}

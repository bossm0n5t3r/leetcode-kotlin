package me.bossm0n5t3r.leetcode.cleardigits

import java.util.Stack

class ClearDigits {
    class Solution {
        fun clearDigits(s: String): String {
            val stack = Stack<Char>()
            for (c in s) {
                when {
                    c.isDigit() -> {
                        if (stack.isNotEmpty() && stack.peek().isLetter()) {
                            stack.pop()
                        }
                    }

                    c.isLetter() -> {
                        stack.push(c)
                    }
                }
            }
            return stack.joinToString("")
        }
    }
}

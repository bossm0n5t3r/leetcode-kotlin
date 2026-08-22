package me.bossm0n5t3r.leetcode.validParentheses

class ValidParentheses {
    class Solution {
        fun isValid(s: String): Boolean {
            val n = s.length
            if (n % 2 != 0) return false
            val stack = CharArray(n)
            var top = 0
            for (c in s) {
                when (c) {
                    '(' -> stack[top++] = ')'
                    '[' -> stack[top++] = ']'
                    '{' -> stack[top++] = '}'
                    else -> if (top == 0 || stack[--top] != c) return false
                }
            }
            return top == 0
        }
    }
}

package me.bossm0n5t3r.leetcode.validParentheses

class ValidParentheses {
    class Solution {
        fun isValid(s: String): Boolean {
            val map = mapOf(')' to '(', '}' to '{', ']' to '[')
            val stack = mutableListOf<Char>()
            s.forEach { c ->
                if (c in map.keys) {
                    if (stack.isEmpty() || stack.last() != map[c]) return false
                    stack.removeAt(stack.size - 1)
                } else {
                    stack.add(c)
                }
            }
            return stack.isEmpty()
        }
    }
}

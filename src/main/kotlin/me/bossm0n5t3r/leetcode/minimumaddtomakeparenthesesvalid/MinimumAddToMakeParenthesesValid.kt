package me.bossm0n5t3r.leetcode.minimumaddtomakeparenthesesvalid

class MinimumAddToMakeParenthesesValid {
    class Solution {
        fun minAddToMakeValid(s: String): Int {
            val result = ArrayDeque<Char>()
            for (c in s) {
                if (c == ')' && result.lastOrNull() == '(') {
                    result.removeLastOrNull()
                    continue
                }
                result.addLast(c)
            }
            return result.size
        }
    }
}

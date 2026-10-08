package me.bossm0n5t3r.leetcode.removeoutermostparentheses

class RemoveOutermostParentheses {
    class Solution {
        fun removeOuterParentheses(s: String): String {
            val result = StringBuilder()
            var depth = 0

            for (c in s) {
                if (c == '(') {
                    if (depth > 0) result.append(c)
                    depth++
                } else {
                    depth--
                    if (depth > 0) result.append(c)
                }
            }

            return result.toString()
        }
    }
}

package me.bossm0n5t3r.leetcode.generateparentheses

class GenerateParentheses {
    class Solution {
        fun generateParenthesis(n: Int): List<String> {
            val result = mutableListOf<String>()
            backtracking(result, "", 0, 0, n)
            return result
        }

        private fun backtracking(
            result: MutableList<String>,
            cur: String,
            open: Int,
            close: Int,
            max: Int,
        ) {
            if (cur.length == max * 2) {
                result.add(cur)
                return
            }
            if (open < max) {
                backtracking(result, "$cur(", open + 1, close, max)
            }
            if (close < open) {
                backtracking(result, "$cur)", open, close + 1, max)
            }
        }
    }
}

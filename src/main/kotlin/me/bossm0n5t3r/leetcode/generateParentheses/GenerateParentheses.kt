package me.bossm0n5t3r.leetcode.generateParentheses

class GenerateParentheses {
    class Solution {
        fun generateParenthesisBruteForce(n: Int): List<String> {
            val result = mutableListOf<String>()
            val arr = CharArray(n * 2)
            generateAllParentheses(result, arr, 0)
            return result
        }

        private fun generateAllParentheses(result: MutableList<String>, arr: CharArray, pos: Int) {
            if (pos == arr.size) {
                val parenthesis = arr.joinToString("")
                if (isValidParenthesis(parenthesis)) {
                    result.add(parenthesis)
                }
                return
            }
            arr[pos] = '('
            generateAllParentheses(result, arr, pos + 1)
            arr[pos] = ')'
            generateAllParentheses(result, arr, pos + 1)
        }

        private fun isValidParenthesis(parenthesis: String): Boolean {
            var balance = 0
            parenthesis.forEach { c ->
                if (c == '(') {
                    balance++
                } else {
                    balance--
                }
                if (balance < 0) return false
            }
            return balance == 0
        }

        fun generateParenthesisBacktracking(n: Int): List<String> {
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

        fun generateParenthesisClosureNumber(n: Int): List<String> {
            val result = mutableListOf<String>()
            if (n == 0) {
                result.add("")
            } else {
                for (c in 0 until n) {
                    for (left in generateParenthesisClosureNumber(c)) {
                        for (right in generateParenthesisClosureNumber(n - 1 - c)) {
                            result.add("($left)$right")
                        }
                    }
                }
            }
            return result
        }
    }
}

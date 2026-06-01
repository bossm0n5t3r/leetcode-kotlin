package me.bossm0n5t3r.leetcode.uniquePaths

class UniquePaths {
    class Solution {
        fun uniquePaths(m: Int, n: Int): Int {
            val min = minOf(m - 1, n - 1)
            val sum = m + n - 2
            var result = 1L
            for (i in 0 until min) {
                result *= (sum - i)
                result /= (i + 1)
            }
            return result.toInt()
        }

        fun uniquePathsUsingDP(m: Int, n: Int): Int {
            val dp = Array(m) { IntArray(n) { 1 } }
            for (r in 1 until m) {
                for (c in 1 until n) {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1]
                }
            }
            return dp[m - 1][n - 1]
        }
    }
}

package me.bossm0n5t3r.leetcode.predictthewinner

class PredictTheWinner {
    class Solution {
        fun predictTheWinner(nums: IntArray): Boolean {
            val n = nums.size
            val dp = Array(n) { IntArray(n) }

            for (i in 0 until n) {
                dp[i][i] = nums[i]
            }

            for (len in 2..n) {
                for (i in 0..n - len) {
                    val j = i + len - 1
                    val takeLeft = nums[i] - dp[i + 1][j]
                    val takeRight = nums[j] - dp[i][j - 1]
                    dp[i][j] = maxOf(takeLeft, takeRight)
                }
            }

            return dp[0][n - 1] >= 0
        }
    }
}

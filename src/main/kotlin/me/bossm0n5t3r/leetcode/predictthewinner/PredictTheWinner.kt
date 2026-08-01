package me.bossm0n5t3r.leetcode.predictthewinner

class PredictTheWinner {
    class Solution {
        fun predictTheWinner(nums: IntArray): Boolean {
            val n = nums.size
            val memo = Array(n) { IntArray(n) { Int.MIN_VALUE } }

            fun scoreDiff(i: Int, j: Int): Int {
                if (i == j) return nums[i]
                if (memo[i][j] != Int.MIN_VALUE) return memo[i][j]

                val takeLeft = nums[i] - scoreDiff(i + 1, j)
                val takeRight = nums[j] - scoreDiff(i, j - 1)

                memo[i][j] = maxOf(takeLeft, takeRight)
                return memo[i][j]
            }

            return scoreDiff(0, n - 1) >= 0
        }
    }
}

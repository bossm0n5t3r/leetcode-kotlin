package me.bossm0n5t3r.leetcode.houserobberii

class HouseRobberII {
    class Solution {
        fun rob(nums: IntArray): Int {
            val n = nums.size
            if (n == 1) return nums[0]
            if (n == 2) return maxOf(nums[0], nums[1])
            return maxOf(doDp(nums.drop(1)), doDp(nums.dropLast(1)))
        }

        private fun doDp(nums: List<Int>): Int {
            val n = nums.size
            val dp = IntArray(n)
            dp[0] = nums[0]
            dp[1] = maxOf(dp[0], nums[1])
            for (i in 2 until n) {
                dp[i] = maxOf(dp[i - 2] + nums[i], dp[i - 1])
            }
            return maxOf(dp[nums.size - 1], dp[nums.size - 2])
        }
    }
}

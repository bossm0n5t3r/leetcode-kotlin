package me.bossm0n5t3r.leetcode.houserobberii

class HouseRobberII {
    class Solution {
        fun rob(nums: IntArray): Int {
            if (nums.size == 1) return nums[0]
            return maxOf(rob(nums, 0, nums.lastIndex - 1), rob(nums, 1, nums.lastIndex))
        }

        private fun rob(nums: IntArray, start: Int, end: Int): Int {
            var prev2 = 0
            var prev1 = 0

            for (i in start..end) {
                val current = maxOf(prev1, prev2 + nums[i])
                prev2 = prev1
                prev1 = current
            }

            return prev1
        }
    }
}

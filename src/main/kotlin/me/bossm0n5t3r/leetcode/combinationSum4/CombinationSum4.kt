package me.bossm0n5t3r.leetcode.combinationSum4

class CombinationSum4 {
    class Solution {
        fun combinationSum4(nums: IntArray, target: Int): Int {
            val dp = IntArray(target + 1) { -1 }.apply { this[0] = 1 }
            return helper(nums, target, dp)
        }

        private fun helper(nums: IntArray, target: Int, dp: IntArray): Int {
            if (dp[target] == -1) {
                dp[target] =
                    nums.indices.sumOf { i ->
                        if (target >= nums[i]) {
                            helper(nums, target - nums[i], dp)
                        } else {
                            0
                        }
                    }
            }
            return dp[target]
        }
    }
}

package me.bossm0n5t3r.leetcode.leftandrightsumdifferences

class LeftAndRightSumDifferences {
    class Solution {
        fun leftRightDifference(nums: IntArray): IntArray {
            var leftSum = 0
            var rightSum = nums.sum()

            return IntArray(nums.size) { i ->
                rightSum -= nums[i]
                val difference = abs(leftSum - rightSum)
                leftSum += nums[i]
                difference
            }
        }

        private fun abs(value: Int): Int = if (value >= 0) value else -value
    }
}

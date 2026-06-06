package me.bossm0n5t3r.leetcode.leftandrightsumdifferences

class LeftAndRightSumDifferences {
    class Solution {
        fun leftRightDifference(nums: IntArray): IntArray {
            val sum = nums.sum()
            val leftSum = IntArray(nums.size)
            val rightSum = IntArray(nums.size)
            for (i in nums.indices) {
                if (i == 0) {
                    rightSum[i] = sum - nums[i]
                    continue
                }
                leftSum[i] = leftSum[i - 1] + nums[i - 1]
                rightSum[i] = rightSum[i - 1] - nums[i]
            }
            val result = IntArray(nums.size)
            for (i in nums.indices) {
                result[i] = leftSum[i] abs rightSum[i]
            }
            return result
        }

        private infix fun Int.abs(other: Int): Int {
            return if (this >= other) this - other else other - this
        }
    }
}

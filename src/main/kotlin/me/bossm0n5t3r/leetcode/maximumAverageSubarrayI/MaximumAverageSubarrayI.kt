package me.bossm0n5t3r.leetcode.maximumAverageSubarrayI

class MaximumAverageSubarrayI {
    class Solution {
        fun findMaxAverage(nums: IntArray, k: Int): Double {
            var tmp = 0.0
            for (i in 0 until k) {
                tmp += nums[i]
            }

            var maxAverage = tmp / k
            for (i in k until nums.size) {
                tmp += nums[i]
                tmp -= nums[i - k]
                val tmpAverage = tmp / k
                if (tmpAverage > maxAverage) maxAverage = tmpAverage
            }
            return maxAverage
        }
    }
}

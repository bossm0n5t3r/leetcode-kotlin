package me.bossm0n5t3r.leetcode.continuousSubarraySum

class ContinuousSubarraySum {
    class Solution {
        fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
            if (nums.size < 2) return false
            val remainderToIndex = mutableMapOf(0 to -1)
            var cumulativeSum = 0
            for ((index, num) in nums.withIndex()) {
                cumulativeSum += num
                val remainder = if (k == 0) cumulativeSum else cumulativeSum % k
                if (remainderToIndex.containsKey(remainder)) {
                    val prevIndex = remainderToIndex[remainder] ?: continue
                    if (index - prevIndex > 1) return true
                    continue
                }
                remainderToIndex[remainder] = index
            }
            return false
        }
    }
}

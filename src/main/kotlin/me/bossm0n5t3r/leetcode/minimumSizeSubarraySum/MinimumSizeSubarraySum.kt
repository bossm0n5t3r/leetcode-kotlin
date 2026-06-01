package me.bossm0n5t3r.leetcode.minimumSizeSubarraySum

class MinimumSizeSubarraySum {
    class Solution {
        fun minSubArrayLen(target: Int, nums: IntArray): Int {
            if (nums.size == 1) return if (nums[0] >= target) 1 else 0

            var result = Int.MAX_VALUE
            var windowStart = 0
            var tmp = 0
            for (windowEnd in nums.indices) {
                if (tmp < target) {
                    tmp += nums[windowEnd]
                }
                while (tmp >= target) {
                    result = minOf(result, windowEnd - windowStart + 1)
                    tmp -= nums[windowStart++]
                }
            }
            return if (result == Int.MAX_VALUE) 0 else result
        }
    }
}

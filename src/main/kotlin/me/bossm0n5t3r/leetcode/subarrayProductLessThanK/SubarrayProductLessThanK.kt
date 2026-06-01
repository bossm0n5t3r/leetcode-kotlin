package me.bossm0n5t3r.leetcode.subarrayProductLessThanK

class SubarrayProductLessThanK {
    class Solution {
        fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
            if (k <= 1) return 0
            var start = 0
            var product = 1.0
            var result = 0
            for (end in nums.indices) {
                product *= nums[end]
                while (product >= k) {
                    product /= nums[start++]
                }
                result += end - start + 1
            }
            return result
        }
    }
}

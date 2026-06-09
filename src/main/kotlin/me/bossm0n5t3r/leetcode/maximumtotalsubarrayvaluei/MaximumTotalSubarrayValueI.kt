package me.bossm0n5t3r.leetcode.maximumtotalsubarrayvaluei

class MaximumTotalSubarrayValueI {
    class Solution {
        fun maxTotalValue(nums: IntArray, k: Int): Long {
            var min: Int = Int.MAX_VALUE
            var max: Int = Int.MIN_VALUE
            for (num in nums) {
                min = minOf(min, num)
                max = maxOf(max, num)
            }
            return (max - min) * k.toLong()
        }
    }
}

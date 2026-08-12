package me.bossm0n5t3r.leetcode.lengthoflongestsubarraywithatmostkfrequency

class LengthOfLongestSubarrayWithAtMostKFrequency {
    class Solution {
        fun maxSubarrayLength(nums: IntArray, k: Int): Int {
            var result = 0
            var start = -1
            val frequency = mutableMapOf<Int, Int>()

            for ((end, endElement) in nums.withIndex()) {
                frequency[endElement] = frequency.getOrDefault(endElement, 0) + 1
                while (frequency[endElement]?.let { it > k } ?: false) {
                    start++
                    frequency[nums[start]] = frequency.getOrDefault(nums[start], 0) - 1
                }
                result = maxOf(result, end - start)
            }

            return result
        }
    }
}

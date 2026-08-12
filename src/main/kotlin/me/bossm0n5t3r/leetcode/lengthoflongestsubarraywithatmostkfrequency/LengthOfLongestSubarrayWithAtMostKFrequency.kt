package me.bossm0n5t3r.leetcode.lengthoflongestsubarraywithatmostkfrequency

class LengthOfLongestSubarrayWithAtMostKFrequency {
    class Solution {
        fun maxSubarrayLength(nums: IntArray, k: Int): Int {
            var result = 0
            var start = 0
            val frequency = mutableMapOf<Int, Int>().withDefault { 0 }

            for (end in nums.indices) {
                val endElement = nums[end]
                frequency[endElement] = frequency.getValue(endElement) + 1

                while (frequency.getValue(endElement) > k) {
                    frequency[nums[start]] = frequency.getValue(nums[start]) - 1
                    start++
                }

                result = maxOf(result, end - start + 1)
            }

            return result
        }
    }
}

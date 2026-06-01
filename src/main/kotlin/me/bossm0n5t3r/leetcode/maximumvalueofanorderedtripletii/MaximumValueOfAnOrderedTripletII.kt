package me.bossm0n5t3r.leetcode.maximumvalueofanorderedtripletii

class MaximumValueOfAnOrderedTripletII {
    class Solution {
        fun maximumTripletValue(nums: IntArray): Long {
            val prefixMax = LongArray(nums.size)
            val suffixMax = LongArray(nums.size)
            for (i in nums.indices) {
                prefixMax[i] =
                    if (i == 0) nums[i].toLong() else maxOf(prefixMax[i - 1], nums[i].toLong())
                suffixMax[nums.size - 1 - i] =
                    if (i == 0) nums[nums.size - 1].toLong()
                    else maxOf(suffixMax[nums.size - i], nums[nums.size - 1 - i].toLong())
            }
            var result = 0L
            for (j in 1 until nums.size - 1) {
                result = maxOf(result, (prefixMax[j - 1] - nums[j]) * suffixMax[j + 1])
            }
            return result
        }
    }
}

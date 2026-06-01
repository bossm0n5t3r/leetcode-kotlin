package me.bossm0n5t3r.leetcode.countthenumberofgoodsubarrays

class CountTheNumberOfGoodSubarrays {
    class Solution {
        fun countGood(nums: IntArray, k: Int): Long {
            var k = k
            var count = 0L
            val countMap = mutableMapOf<Int, Int>()
            var start = 0
            var end = 0
            while (end < nums.size) {
                k -= countMap.getOrDefault(nums[end], 0)
                countMap[nums[end]] = countMap.getOrDefault(nums[end], 0) + 1
                while (k <= 0) {
                    val tmp = countMap.getValue(nums[start]) - 1
                    countMap[nums[start++]] = tmp
                    k += tmp
                }
                count += start.toLong()
                ++end
            }
            return count
        }
    }
}

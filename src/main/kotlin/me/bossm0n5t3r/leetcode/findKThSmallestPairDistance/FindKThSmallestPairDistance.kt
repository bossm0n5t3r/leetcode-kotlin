package me.bossm0n5t3r.leetcode.findKThSmallestPairDistance

import kotlin.math.abs

class FindKThSmallestPairDistance {
    class Solution {
        fun smallestDistancePair(nums: IntArray, k: Int): Int {
            val countArray = IntArray(1_000_001)
            for (i in 0 until nums.size - 1) {
                for (j in i + 1 until nums.size) {
                    val distance = abs(nums[j] - nums[i])
                    countArray[distance]++
                }
            }
            var result = 0
            var tmpTotal = 0
            while (tmpTotal < k) {
                tmpTotal += countArray[result++]
            }
            return result - 1
        }
    }
}

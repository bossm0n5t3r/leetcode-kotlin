package me.bossm0n5t3r.leetcode.threeSumClosest

import kotlin.math.abs

class ThreeSumClosest {
    class Solution {
        fun threeSumClosest(nums: IntArray, target: Int): Int {
            val sortedNums = nums.sorted()
            var result = sortedNums.first() + sortedNums.last() + sortedNums[1]
            val size = sortedNums.size
            (0 until size - 2).forEach { i ->
                var start = i + 1
                var end = size - 1
                while (start < end) {
                    val tmpSum = sortedNums[i] + sortedNums[start] + sortedNums[end]
                    if (tmpSum > target) {
                        end--
                    } else {
                        start++
                    }
                    if (abs(target - result) > abs(target - tmpSum)) {
                        result = tmpSum
                    }
                }
            }
            return result
        }
    }
}

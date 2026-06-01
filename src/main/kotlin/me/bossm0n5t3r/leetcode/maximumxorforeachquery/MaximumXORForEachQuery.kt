package me.bossm0n5t3r.leetcode.maximumxorforeachquery

import kotlin.math.pow

class MaximumXORForEachQuery {
    class Solution {
        fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
            val maxPossibleXorResult = 2.0.pow(maximumBit).toInt() - 1
            var totalXor = nums.reduce { acc, i -> acc xor i }
            return nums.indices
                .map { index ->
                    (maxPossibleXorResult xor totalXor).also {
                        totalXor = totalXor xor nums[nums.lastIndex - index]
                    }
                }
                .toIntArray()
        }
    }
}

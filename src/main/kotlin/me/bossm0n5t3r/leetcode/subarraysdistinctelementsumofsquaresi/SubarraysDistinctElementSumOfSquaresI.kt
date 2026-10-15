package me.bossm0n5t3r.leetcode.subarraysdistinctelementsumofsquaresi

class SubarraysDistinctElementSumOfSquaresI {
    class Solution {
        fun sumCounts(nums: List<Int>): Int {
            var result = 0

            for (i in nums.indices) {
                val distinct = mutableSetOf<Int>()

                for (j in i until nums.size) {
                    distinct += nums[j]
                    result += distinct.size * distinct.size
                }
            }

            return result
        }
    }
}

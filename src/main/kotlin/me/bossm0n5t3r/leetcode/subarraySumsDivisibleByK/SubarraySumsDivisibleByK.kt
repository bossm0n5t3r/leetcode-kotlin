package me.bossm0n5t3r.leetcode.subarraySumsDivisibleByK

class SubarraySumsDivisibleByK {
    class Solution {
        fun subarraysDivByK(nums: IntArray, k: Int): Int {
            var result = 0
            var cumulativeSum = 0
            val prefixMap = mutableMapOf(0 to 1)
            for (num in nums) {
                cumulativeSum += num
                var remainder = cumulativeSum % k
                if (remainder < 0) {
                    remainder += k
                }
                prefixMap[remainder] =
                    if (prefixMap.containsKey(remainder)) {
                        val target = prefixMap.getOrDefault(remainder, 0)
                        result += target
                        target + 1
                    } else {
                        1
                    }
            }
            return result
        }
    }
}

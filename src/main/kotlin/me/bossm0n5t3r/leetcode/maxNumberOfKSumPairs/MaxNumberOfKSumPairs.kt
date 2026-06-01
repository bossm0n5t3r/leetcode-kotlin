package me.bossm0n5t3r.leetcode.maxNumberOfKSumPairs

class MaxNumberOfKSumPairs {
    class Solution {
        fun maxOperations(nums: IntArray, k: Int): Int {
            val numToCount = mutableMapOf<Int, Int>()
            var operations = 0
            for (num in nums) {
                if (num > k) continue
                val diff = k - num
                val diffCount = numToCount[diff] ?: 0
                if (diffCount > 0) {
                    numToCount[diff] = diffCount - 1
                    operations++
                } else {
                    numToCount[num] = (numToCount[num] ?: 0) + 1
                }
            }
            return operations
        }
    }
}

package me.bossm0n5t3r.leetcode.minimumoperationstomakearrayvaluesequaltok

class MinimumOperationsToMakeArrayValuesEqualToK {
    class Solution {
        fun minOperations(nums: IntArray, k: Int): Int {
            return nums.minOrNull()?.let {
                val countElement = nums.toSet().size
                when {
                    k > it -> null
                    it == k -> return@let countElement - 1
                    else -> countElement
                }
            } ?: -1
        }
    }
}

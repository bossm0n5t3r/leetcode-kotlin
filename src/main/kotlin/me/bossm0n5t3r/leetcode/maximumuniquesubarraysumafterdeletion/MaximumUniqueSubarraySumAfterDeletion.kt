package me.bossm0n5t3r.leetcode.maximumuniquesubarraysumafterdeletion

class MaximumUniqueSubarraySumAfterDeletion {
    class Solution {
        fun maxSum(nums: IntArray): Int =
            nums.filter { it > 0 }.takeIf { it.isNotEmpty() }?.toSet()?.sum() ?: nums.max()
    }
}

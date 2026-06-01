package me.bossm0n5t3r.leetcode.minimumNumberOfOperationsToMakeArrayXorEqualToK

class MinimumNumberOfOperationsToMakeArrayXorEqualToK {
    class Solution {
        fun minOperations(nums: IntArray, k: Int): Int =
            nums.fold(k) { acc, i -> acc xor i }.toString(2).count { it == '1' }
    }
}

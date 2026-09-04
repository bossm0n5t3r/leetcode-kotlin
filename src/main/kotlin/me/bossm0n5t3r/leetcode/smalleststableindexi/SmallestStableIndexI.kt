package me.bossm0n5t3r.leetcode.smalleststableindexi

class SmallestStableIndexI {
    class Solution {
        fun firstStableIndex(nums: IntArray, k: Int): Int {
            val n = nums.size
            val suffixMin = IntArray(n) { Int.MAX_VALUE }
            suffixMin[n - 1] = nums[n - 1]
            for (i in n - 2 downTo 0) {
                suffixMin[i] = if (nums[i] < suffixMin[i + 1]) nums[i] else suffixMin[i + 1]
            }
            var prefixMax = nums[0]
            for (i in 0 until n) {
                prefixMax = maxOf(prefixMax, nums[i])
                if (prefixMax - suffixMin[i] <= k) {
                    return i
                }
            }
            return -1
        }
    }
}

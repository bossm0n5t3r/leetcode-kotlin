package me.bossm0n5t3r.leetcode.smalleststableindexi

class SmallestStableIndexI {
    class Solution {
        fun firstStableIndex(nums: IntArray, k: Int): Int {
            val n = nums.size
            val max = IntArray(n) { Int.MIN_VALUE }
            max[0] = nums[0]
            for (i in 1 until n) {
                max[i] = if (nums[i] > max[i - 1]) nums[i] else max[i - 1]
            }
            val min = IntArray(n) { Int.MAX_VALUE }
            min[n - 1] = nums[n - 1]
            for (i in n - 2 downTo 0) {
                min[i] = if (nums[i] < min[i + 1]) nums[i] else min[i + 1]
            }
            for (i in 0 until n) {
                if (max[i] - min[i] <= k) return i
            }
            return -1
        }
    }
}

package me.bossm0n5t3r.leetcode.countequalanddivisiblepairsinanarray

class CountEqualAndDivisiblePairsInAnArray {
    class Solution {
        fun countPairs(nums: IntArray, k: Int): Int {
            val n = nums.size
            var count = 0
            for (i in 0 until n - 1) {
                for (j in i + 1 until n) {
                    if (nums[i] != nums[j]) continue
                    if (i * j % k != 0) continue
                    count++
                }
            }
            return count
        }
    }
}

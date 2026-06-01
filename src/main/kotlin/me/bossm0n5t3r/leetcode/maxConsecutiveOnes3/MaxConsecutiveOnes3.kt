package me.bossm0n5t3r.leetcode.maxConsecutiveOnes3

class MaxConsecutiveOnes3 {
    class Solution {
        fun longestOnes(nums: IntArray, k: Int): Int {
            var (s, e) = 0 to 0
            var flipCount = k
            while (e < nums.size) {
                if (nums[e] == 0) {
                    flipCount--
                }
                if (flipCount < 0) {
                    if (nums[s] == 0) {
                        flipCount++
                    }
                    s++
                }
                e++
            }
            return e - s
        }
    }
}

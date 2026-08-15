package me.bossm0n5t3r.leetcode.longestsubsequencewithnonzerobitwisexor

class LongestSubsequenceWithNonZeroBitwiseXOR {
    class Solution {
        fun longestSubsequence(nums: IntArray): Int {
            var countZero = 0
            val acc = nums.reduce { acc, i ->
                if (i == 0) countZero++
                acc xor i
            }
            return when {
                acc == 0 && countZero == nums.size - 1 -> 0
                acc == 0 -> nums.size - 1
                else -> nums.size
            }
        }
    }
}

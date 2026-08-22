package me.bossm0n5t3r.leetcode.longestconsecutivesequence

class LongestConsecutiveSequence {
    class Solution {
        fun longestConsecutive(nums: IntArray): Int {
            val set = nums.toHashSet()
            var result = 0
            for (num in set) {
                if (num - 1 in set) continue
                var current = num
                var length = 1
                while (current + 1 in set) {
                    current++
                    length++
                }
                result = maxOf(result, length)
            }
            return result
        }
    }
}

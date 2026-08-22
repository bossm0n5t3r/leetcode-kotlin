package me.bossm0n5t3r.leetcode.longestconsecutivesequence

class LongestConsecutiveSequence {
    class Solution {
        fun longestConsecutive(nums: IntArray): Int {
            val set = mutableSetOf<Int>()
            for (num in nums) set += num
            var result = 0
            for (num in nums) {
                if (num !in set) continue
                var tmp = num
                val downSide = mutableSetOf<Int>()
                while (tmp - 1 in set) {
                    tmp--
                    downSide += tmp
                }
                tmp = num
                val upSide = mutableSetOf<Int>()
                while (tmp + 1 in set) {
                    tmp++
                    upSide += tmp
                }
                val total = downSide + num + upSide
                result = maxOf(result, total.size)
                set -= total
            }
            return result
        }
    }
}

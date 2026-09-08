package me.bossm0n5t3r.leetcode.countcommasinrangeii

class CountCommasInRangeII {
    class Solution {
        fun countCommas(n: Long): Long {
            var result = 0L
            var threshold = 1_000L
            while (threshold <= n) {
                result += n - threshold + 1
                threshold *= 1_000
            }
            return result
        }
    }
}

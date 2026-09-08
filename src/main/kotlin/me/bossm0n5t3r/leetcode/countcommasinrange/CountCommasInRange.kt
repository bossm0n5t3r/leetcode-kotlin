package me.bossm0n5t3r.leetcode.countcommasinrange

class CountCommasInRange {
    class Solution {
        fun countCommas(n: Int): Int {
            var result = 0L
            var threshold = 1_000L
            while (threshold <= n) {
                result += n.toLong() - threshold + 1
                threshold *= 1_000
            }
            return result.toInt()
        }
    }
}

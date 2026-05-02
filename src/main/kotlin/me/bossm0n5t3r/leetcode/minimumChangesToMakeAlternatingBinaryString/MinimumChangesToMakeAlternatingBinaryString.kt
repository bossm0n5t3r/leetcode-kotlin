package me.bossm0n5t3r.leetcode.minimumChangesToMakeAlternatingBinaryString

class MinimumChangesToMakeAlternatingBinaryString {
    class Solution {
        fun minOperations(s: String): Int {
            var count = 0
            for (i in s.indices) {
                if ((i % 2 == 0 && s[i] == '0') || (i % 2 == 1 && s[i] == '1')) {
                    count++
                }
            }
            return minOf(count, s.length - count)
        }
    }
}

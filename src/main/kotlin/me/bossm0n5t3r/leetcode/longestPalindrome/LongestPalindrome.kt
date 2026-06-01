package me.bossm0n5t3r.leetcode.longestPalindrome

class LongestPalindrome {
    class Solution {
        fun longestPalindrome(s: String): Int {
            val countListForEachChar = s.groupingBy { it }.eachCount().values.toList()
            var result = 0
            var existOdd = false
            for (count in countListForEachChar) {
                result +=
                    if (count % 2 == 0) {
                        count
                    } else {
                        existOdd = true
                        count - 1
                    }
            }
            if (existOdd) {
                result++
            }
            return result
        }
    }
}

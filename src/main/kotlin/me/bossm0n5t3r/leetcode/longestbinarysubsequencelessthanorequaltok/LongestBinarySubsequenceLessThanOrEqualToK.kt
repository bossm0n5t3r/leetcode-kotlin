package me.bossm0n5t3r.leetcode.longestbinarysubsequencelessthanorequaltok

class LongestBinarySubsequenceLessThanOrEqualToK {
    class Solution {
        fun longestSubsequence(s: String, k: Int): Int {
            var resultString = ""
            var index = s.lastIndex
            while (index > -1) {
                val tmp = "${s[index]}$resultString".toLongOrNull(2)
                if (tmp == null || tmp > k) break
                resultString = "${s[index--]}$resultString"
            }
            return s.substring(0, index + 1).count { it == '0' } + resultString.length
        }
    }
}

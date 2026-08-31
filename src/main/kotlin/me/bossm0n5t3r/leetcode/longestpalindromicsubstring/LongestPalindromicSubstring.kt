package me.bossm0n5t3r.leetcode.longestpalindromicsubstring

class LongestPalindromicSubstring {
    class Solution {
        fun longestPalindrome(s: String): String {
            val n = s.length
            val dp = Array(n) { BooleanArray(n) }

            for (i in 0 until n) dp[i][i] = true

            var bestStart = 0
            var bestLength = 1

            for (length in 2..n) {
                for (left in 0..(n - length)) {
                    val right = left + length - 1
                    if (s[left] != s[right]) continue
                    dp[left][right] = length == 2 || dp[left + 1][right - 1]
                    if (dp[left][right] && length > bestLength) {
                        bestStart = left
                        bestLength = length
                    }
                }
            }

            return s.substring(bestStart, bestStart + bestLength)
        }
    }
}

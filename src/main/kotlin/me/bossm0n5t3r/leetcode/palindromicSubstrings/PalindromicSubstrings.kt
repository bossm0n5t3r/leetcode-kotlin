package me.bossm0n5t3r.leetcode.palindromicSubstrings

class PalindromicSubstrings {
    class Solution {
        fun countSubstrings(s: String): Int {
            var result = 0
            val n = s.length
            (0 until n).forEach { i ->
                (i until n).forEach { j -> if (isPalindrome(s.substring(i, j + 1))) result++ }
            }
            return result
        }

        fun isPalindrome(s: String): Boolean {
            val n = s.length
            (0..(n / 2)).forEach { i -> if (s[i] != s[n - 1 - i]) return false }
            return true
        }

        fun countSubstringsUsingDP(s: String): Int {
            /**
             * https://leetcode.com/problems/palindromic-substrings/discuss/258917/Java-Simple-Code:-DP-short
             */
            var result = 0
            val n = s.length
            val dp = Array(n) { BooleanArray(n) { false } }
            (0 until n).forEach { d ->
                (0 until n - d).forEach { r ->
                    val c = r + d
                    if (s[r] == s[c]) {
                        dp[r][c] = if (r + 1 >= c - 1) true else dp[r + 1][c - 1]
                        if (dp[r][c]) result++
                    }
                }
            }
            return result
        }
    }
}

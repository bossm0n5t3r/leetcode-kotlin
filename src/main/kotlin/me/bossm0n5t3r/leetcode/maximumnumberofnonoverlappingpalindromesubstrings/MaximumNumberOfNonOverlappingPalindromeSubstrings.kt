package me.bossm0n5t3r.leetcode.maximumnumberofnonoverlappingpalindromesubstrings

class MaximumNumberOfNonOverlappingPalindromeSubstrings {
    class Solution {
        fun maxPalindromes(s: String, k: Int): Int {
            val n = s.length
            val palindrome = Array(n) { BooleanArray(n) }

            for (i in 0 until n) palindrome[i][i] = true

            for (length in 2..n) {
                for (start in 0..(n - length)) {
                    val end = start + length - 1
                    if (s[start] != s[end]) continue
                    palindrome[start][end] = length == 2 || palindrome[start + 1][end - 1]
                }
            }

            val dp = IntArray(n + 1)

            for (endExclusive in 1..n) {
                dp[endExclusive] = dp[endExclusive - 1]
                val end = endExclusive - 1
                for (start in 0..end) {
                    val length = end - start + 1
                    if (length >= k && palindrome[start][end]) {
                        dp[endExclusive] = maxOf(dp[endExclusive], dp[start] + 1)
                    }
                }
            }

            return dp[n]
        }
    }
}

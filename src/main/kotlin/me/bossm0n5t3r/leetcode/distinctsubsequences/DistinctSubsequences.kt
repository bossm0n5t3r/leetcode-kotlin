package me.bossm0n5t3r.leetcode.distinctsubsequences

class DistinctSubsequences {
    class Solution {
        fun numDistinct(s: String, t: String): Int {
            val sLength = s.length
            val tLength = t.length
            val dp = Array(sLength + 1) { IntArray(tLength + 1) }
            for (r in 0..sLength) dp[r][0] = 1
            for (r in 1..sLength) {
                for (c in 1..tLength) {
                    dp[r][c] =
                        if (s[r - 1] == t[c - 1]) {
                            dp[r - 1][c - 1] + dp[r - 1][c]
                        } else {
                            dp[r - 1][c]
                        }
                }
            }
            return dp[sLength][tLength]
        }
    }
}

package me.bossm0n5t3r.leetcode.distinctsubsequencesii

class DistinctSubsequencesII {
    class Solution {
        fun distinctSubseqII(s: String): Int {
            val modulo = 1_000_000_007
            val n = s.length
            val dp = IntArray(n + 1)
            dp[0] = 1
            val last = IntArray(26) { -1 }
            for (i in 1..n) {
                dp[i] = ((dp[i - 1].toLong() * 2) % modulo).toInt()
                val curIndex = s[i - 1] - 'a'
                if (last[curIndex] != -1) {
                    val previousIndex = last[curIndex]
                    dp[i] = ((dp[i].toLong() - dp[previousIndex - 1] + modulo) % modulo).toInt()
                }
                last[curIndex] = i
            }
            return (dp[n] - 1 + modulo) % modulo
        }
    }
}

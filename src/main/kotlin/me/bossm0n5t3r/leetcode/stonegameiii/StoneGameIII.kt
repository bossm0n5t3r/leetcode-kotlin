package me.bossm0n5t3r.leetcode.stonegameiii

class StoneGameIII {
    class Solution {
        fun stoneGameIII(stoneValue: IntArray): String {
            val n = stoneValue.size
            val dp = IntArray(n + 1) { Int.MIN_VALUE }
            dp[n] = 0
            for (i in n - 1 downTo 0) {
                var total = 0
                for (j in i until minOf(i + 3, n)) {
                    total += stoneValue[j]
                    dp[i] = maxOf(dp[i], total - dp[j + 1])
                }
            }
            val result = dp[0]
            return when {
                result > 0 -> "Alice"
                result < 0 -> "Bob"
                else -> "Tie"
            }
        }
    }
}

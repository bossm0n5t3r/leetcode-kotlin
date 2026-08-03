package me.bossm0n5t3r.leetcode.stonegameiii

class StoneGameIII {
    class Solution {
        fun stoneGameIII(stoneValue: IntArray): String {
            val n = stoneValue.size
            val dp = IntArray(n + 1) { 0 }
            for (i in n - 1 downTo 0) {
                var best = Int.MIN_VALUE
                var sum = 0
                for (k in 1..3) {
                    if (i + k > n) break
                    sum += stoneValue[i + k - 1]
                    best = maxOf(best, sum - dp[i + k])
                }
                dp[i] = best
            }

            return when {
                dp[0] > 0 -> "Alice"
                dp[0] < 0 -> "Bob"
                else -> "Tie"
            }
        }
    }
}

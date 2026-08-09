package me.bossm0n5t3r.leetcode.stonegameii

class StoneGameII {
    class Solution {
        fun stoneGameII(piles: IntArray): Int {
            val n = piles.size
            val memo = Array(n) { IntArray(n + 1) { -1 } }

            // suffixSum[i] = piles[i] + ... + piles[n-1]
            val suffixSum = IntArray(n + 1)
            for (i in n - 1 downTo 0) suffixSum[i] = suffixSum[i + 1] + piles[i]

            fun dp(i: Int, m: Int): Int {
                if (i >= n) return 0
                if (memo[i][m] != -1) return memo[i][m]

                var result = 0
                for (x in 1..(2 * m).coerceAtMost(n - i)) {
                    val current = suffixSum[i] - dp(i + x, maxOf(m, x))
                    result = maxOf(result, current)
                }
                memo[i][m] = result
                return result
            }

            return dp(0, 1)
        }
    }
}

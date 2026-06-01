package me.bossm0n5t3r.leetcode.findallpossiblestablebinaryarraysi

class FindAllPossibleStableBinaryArraysI {
    class Solution {
        fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
            val modulo: Long = 1_000_000_007
            val dp = Array(zero + 1) { Array(one + 1) { LongArray(2) } }
            for (i in 0..minOf(zero, limit)) {
                dp[i][0][0] = 1
            }
            for (j in 0..minOf(one, limit)) {
                dp[0][j][1] = 1
            }
            for (i in 1..zero) {
                for (j in 1..one) {
                    dp[i][j][0] =
                        if (i > limit) {
                            dp[i - 1][j][0] + dp[i - 1][j][1] - dp[i - limit - 1][j][1]
                        } else {
                            dp[i - 1][j][0] + dp[i - 1][j][1]
                        }
                    dp[i][j][0] = ((dp[i][j][0] % modulo) + modulo) % modulo
                    dp[i][j][1] =
                        if (j > limit) {
                            dp[i][j - 1][1] + dp[i][j - 1][0] - dp[i][j - limit - 1][0]
                        } else {
                            dp[i][j - 1][1] + dp[i][j - 1][0]
                        }
                    dp[i][j][1] = ((dp[i][j][1] % modulo) + modulo) % modulo
                }
            }
            return ((dp[zero][one][0] + dp[zero][one][1]) % modulo).toInt()
        }
    }
}

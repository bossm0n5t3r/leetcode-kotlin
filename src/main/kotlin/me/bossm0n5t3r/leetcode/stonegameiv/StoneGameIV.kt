package me.bossm0n5t3r.leetcode.stonegameiv

class StoneGameIV {
    class Solution {
        fun winnerSquareGame(n: Int): Boolean {
            val dp = BooleanArray(n + 1)
            for (i in 1..n) {
                var j = 1
                while (j * j <= i) {
                    if (!dp[i - j * j]) {
                        dp[i] = true
                        break
                    }
                    j++
                }
            }
            return dp[n]
        }
    }
}

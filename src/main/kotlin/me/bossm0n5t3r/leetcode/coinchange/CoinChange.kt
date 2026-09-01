package me.bossm0n5t3r.leetcode.coinchange

class CoinChange {
    class Solution {
        fun coinChange(coins: IntArray, amount: Int): Int {
            val max = amount + 1
            val dp = IntArray(max) { max }
            dp[0] = 0
            for (i in 1..amount) {
                for (coin in coins) {
                    if (coin <= i) {
                        dp[i] = minOf(dp[i], dp[i - coin] + 1)
                    }
                }
            }
            return if (dp[amount] > amount) -1 else dp[amount]
        }
    }
}

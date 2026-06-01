package me.bossm0n5t3r.leetcode.coinChange

import kotlin.math.min

class CoinChange {
    class Solution {
        fun coinChange(coins: IntArray, amount: Int): Int {
            if (amount == 0) return 0
            val max = amount + 1
            val dp = IntArray(amount + 1) { max }
            dp[0] = 0
            (1..amount).forEach {
                coins.forEach { coin ->
                    if (it - coin >= 0) {
                        dp[it] = min(dp[it], dp[it - coin] + 1)
                    }
                }
            }
            return if (dp[amount] > amount) -1 else dp[amount]
        }
    }
}

package me.bossm0n5t3r.leetcode.besttimetobuyandsellstock

class BestTimeToBuyAndSellStock {
    class Solution {
        fun maxProfit(prices: IntArray): Int {
            var s = 0
            var result = 0
            for (e in 1 until prices.size) {
                if (prices[s] < prices[e]) {
                    result = maxOf(result, prices[e] - prices[s])
                } else {
                    s = e
                }
            }
            return result
        }
    }
}

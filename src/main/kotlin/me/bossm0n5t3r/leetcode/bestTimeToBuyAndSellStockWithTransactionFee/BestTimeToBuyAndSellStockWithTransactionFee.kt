package me.bossm0n5t3r.leetcode.bestTimeToBuyAndSellStockWithTransactionFee

class BestTimeToBuyAndSellStockWithTransactionFee {
    class Solution {
        fun maxProfit(prices: IntArray, fee: Int): Int {
            var tmp: Int? = null
            var result = 0
            for (price in prices) {
                tmp = tmp?.let { maxOf(it, result - price) } ?: -price
                result = maxOf(result, tmp + price - fee)
            }
            return result
        }
    }
}

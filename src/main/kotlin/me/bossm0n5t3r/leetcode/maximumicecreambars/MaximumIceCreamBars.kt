package me.bossm0n5t3r.leetcode.maximumicecreambars

class MaximumIceCreamBars {
    class Solution {
        fun maxIceCream(costs: IntArray, coins: Int): Int {
            val countsByCost = IntArray(100_001)
            for (cost in costs) {
                countsByCost[cost]++
            }

            var result = 0
            var remainingCoins = coins

            for (cost in 1 until countsByCost.size) {
                if (remainingCoins < cost) break
                val canBuy = minOf(countsByCost[cost], remainingCoins / cost)
                result += canBuy
                remainingCoins -= canBuy * cost
            }
            return result
        }
    }
}

package me.bossm0n5t3r.leetcode.maximumicecreambars

class MaximumIceCreamBars {
    class Solution {
        fun maxIceCream(costs: IntArray, coins: Int): Int {
            val countIceCreams = IntArray(100_001) { 0 }
            for (cost in costs) {
                countIceCreams[cost]++
            }
            var result = 0
            var remainedCoins = coins
            var cost = 1
            while (remainedCoins > 0 && cost < 100_001) {
                var count = countIceCreams[cost]
                while (count > 0 && remainedCoins >= cost) {
                    result++
                    remainedCoins -= cost
                    count--
                }
                if (remainedCoins < cost) break
                cost++
            }
            return result
        }
    }
}

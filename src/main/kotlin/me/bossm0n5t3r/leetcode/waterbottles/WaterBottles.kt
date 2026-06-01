package me.bossm0n5t3r.leetcode.waterbottles

class WaterBottles {
    class Solution {
        fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
            var total = numBottles
            var remainder = numBottles
            while (remainder >= numExchange) {
                total += remainder / numExchange
                remainder = (remainder / numExchange) + (remainder % numExchange)
            }
            return total
        }
    }
}

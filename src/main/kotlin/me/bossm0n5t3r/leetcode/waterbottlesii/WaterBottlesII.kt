package me.bossm0n5t3r.leetcode.waterbottlesii

class WaterBottlesII {
    class Solution {
        fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
            var total = 0
            var fullBottles = numBottles
            var emptyBottles = 0
            var currentNumExchange = numExchange
            while (fullBottles > 0) {
                total += fullBottles
                emptyBottles += fullBottles
                fullBottles = 0
                while (emptyBottles >= currentNumExchange) {
                    emptyBottles -= currentNumExchange
                    fullBottles++
                    currentNumExchange++
                }
            }
            return total
        }
    }
}

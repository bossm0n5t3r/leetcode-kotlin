package me.bossm0n5t3r.leetcode.gasstation

class GasStation {
    class Solution {
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            var totalGas = 0
            var totalCost = 0
            var currentGas = 0
            var start = 0
            for (i in gas.indices) {
                totalGas += gas[i]
                totalCost += cost[i]
                currentGas += gas[i] - cost[i]
                if (currentGas < 0) {
                    start = i + 1
                    currentGas = 0
                }
            }
            return if (totalGas >= totalCost) start else -1
        }
    }
}

package me.bossm0n5t3r.leetcode.findMissingObservations

class FindMissingObservations {
    class Solution {
        fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
            val sumOfRolls = rolls.sum()
            val totalSum = mean * (n + rolls.size)
            val sumOfResult = totalSum - sumOfRolls
            if (sumOfResult < n || 6 * n < sumOfResult) return intArrayOf()
            val result = IntArray(n) { sumOfResult / n }
            var remainder = sumOfResult % n
            for (i in 0 until n) {
                if (remainder == 0) break
                while (result[i] < 6 && remainder > 0) {
                    remainder--
                    result[i]++
                }
            }
            return result
        }
    }
}

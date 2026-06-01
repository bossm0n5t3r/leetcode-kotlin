package me.bossm0n5t3r.leetcode.mostProfitAssigningWork

class MostProfitAssigningWork {
    class Solution {
        fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
            val sortedDifficultyAndProfit = difficulty.zip(profit).sortedBy { it.first }
            return worker.toList().mapNotNull { findMaxProfit(sortedDifficultyAndProfit, it) }.sum()
        }

        private fun findMaxProfit(difficultyAndProfit: List<Pair<Int, Int>>, ability: Int): Int? {
            var maxProfit = Int.MIN_VALUE
            for ((difficulty, profit) in difficultyAndProfit) {
                if (ability < difficulty) break
                maxProfit = maxOf(maxProfit, profit)
            }
            return maxProfit.takeIf { it != Int.MIN_VALUE }
        }
    }
}

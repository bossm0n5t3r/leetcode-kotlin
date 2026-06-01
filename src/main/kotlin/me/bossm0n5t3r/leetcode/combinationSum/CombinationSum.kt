package me.bossm0n5t3r.leetcode.combinationSum

class CombinationSum {
    class Solution {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val sortedCandidates = candidates.sorted()
            val result = mutableSetOf<List<Int>>()
            sortedCandidates.indices.forEach {
                backtracking(result, listOf(), sortedCandidates, target, it)
            }
            return result.toList()
        }

        private fun backtracking(
            result: MutableSet<List<Int>>,
            container: List<Int>,
            sortedCandidates: List<Int>,
            target: Int,
            index: Int,
        ) {
            val currentSum = container.sum()
            if (currentSum > target) return
            if (currentSum == target) {
                result.add(container)
                return
            }
            for (i in index until sortedCandidates.size) {
                backtracking(result, container + sortedCandidates[i], sortedCandidates, target, i)
            }
        }
    }
}

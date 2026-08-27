package me.bossm0n5t3r.leetcode.combinationsum

class CombinationSum {
    class Solution {
        fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
            val sortedCandidates = candidates.sorted()
            val result = mutableSetOf<List<Int>>()
            for (i in sortedCandidates.indices) {
                backtracking(result, listOf(), sortedCandidates, target, i)
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
            val sum = container.sum()
            if (sum > target) return
            if (sum == target) {
                result += container
                return
            }
            for (i in index until sortedCandidates.size) {
                backtracking(result, container + sortedCandidates[i], sortedCandidates, target, i)
            }
        }
    }
}

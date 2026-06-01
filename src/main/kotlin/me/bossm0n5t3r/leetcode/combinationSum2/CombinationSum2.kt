package me.bossm0n5t3r.leetcode.combinationSum2

class CombinationSum2 {
    class Solution {
        fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
            val sortedCandidates = candidates.sorted()
            val result = mutableSetOf<List<Int>>()
            sortedCandidates.indices.forEach {
                backtracking(result, listOf(sortedCandidates[it]), sortedCandidates, target, it)
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
            val visited = mutableSetOf<List<Int>>()
            for (i in index + 1 until sortedCandidates.size) {
                val tmp = container + sortedCandidates[i]
                if (!visited.contains(tmp)) {
                    backtracking(result, tmp, sortedCandidates, target, i)
                    visited.add(tmp)
                }
            }
        }
    }
}

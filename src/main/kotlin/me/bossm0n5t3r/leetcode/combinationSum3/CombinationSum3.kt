package me.bossm0n5t3r.leetcode.combinationSum3

class CombinationSum3 {
    class Solution {
        fun combinationSum3(k: Int, n: Int): List<List<Int>> {
            val result = mutableListOf<MutableList<Int>>()
            backtrack(result, mutableListOf(), k, n, 1)
            return result
        }

        private fun backtrack(
            result: MutableList<MutableList<Int>>,
            current: MutableList<Int>,
            k: Int,
            n: Int,
            start: Int,
        ) {
            val totalSum = current.sum()
            if (totalSum > n) return
            if (current.size > k) return
            if (current.sum() == n) {
                if (current.size == k) {
                    result.add(current.toMutableList())
                }
                return
            }

            for (i in start..9) {
                backtrack(result, (current + i).toMutableList(), k, n, i + 1)
            }
        }
    }
}

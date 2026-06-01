package me.bossm0n5t3r.leetcode.sumOfAllSubsetXorTotals

class SumOfAllSubsetXorTotals {
    class Solution {
        fun subsetXORSum(nums: IntArray): Int {
            val result = IntArray(1) { 0 }
            dfs(nums, 0, 0, result)
            return result.first()
        }

        private fun dfs(nums: IntArray, index: Int, curXor: Int, result: IntArray) {
            if (index == nums.size) {
                result[0] += curXor
                return
            }
            dfs(nums, index + 1, curXor xor nums[index], result)
            dfs(nums, index + 1, curXor, result)
        }
    }
}

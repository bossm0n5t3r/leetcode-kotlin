package me.bossm0n5t3r.leetcode.countnumberofmaximumbitwiseorsubsets

class CountNumberOfMaximumBitwiseORSubsets {
    class Solution {
        fun countMaxOrSubsets(nums: IntArray): Int {
            val maxOr = nums.reduce { acc, i -> acc or i }
            val result = IntArray(1)
            dfs(nums, maxOr, 0, 0, result)
            return result.first()
        }

        private fun dfs(nums: IntArray, maxOr: Int, index: Int, acc: Int, result: IntArray) {
            if (index == nums.size) {
                if (acc == maxOr) {
                    result[0]++
                }
                return
            }
            dfs(nums, maxOr, index + 1, acc, result)
            dfs(nums, maxOr, index + 1, acc or nums[index], result)
        }
    }
}

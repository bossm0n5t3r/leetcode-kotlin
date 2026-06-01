package me.bossm0n5t3r.leetcode.theNumberOfBeautifulSubsets

class TheNumberOfBeautifulSubsets {
    class Solution {
        fun beautifulSubsets(nums: IntArray, k: Int): Int {
            val result = mutableListOf<MutableList<Int>>()
            dfs(nums, k, 0, mutableListOf(), result)
            return result.size
        }

        private fun dfs(
            nums: IntArray,
            k: Int,
            index: Int,
            cur: MutableList<Int>,
            result: MutableList<MutableList<Int>>,
        ) {
            if (index == nums.size) {
                if (cur.isNotEmpty()) {
                    result.add(cur)
                }
                return
            }
            dfs(nums, k, index + 1, cur, result)
            if (cur.any { abs(it - nums[index]) == k }.not()) {
                dfs(nums, k, index + 1, (cur + nums[index]).toMutableList(), result)
            }
        }

        private fun abs(a: Int): Int = if (a < 0) -a else a
    }
}

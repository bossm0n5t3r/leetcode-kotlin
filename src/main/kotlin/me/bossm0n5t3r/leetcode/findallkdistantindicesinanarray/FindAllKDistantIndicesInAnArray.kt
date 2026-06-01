package me.bossm0n5t3r.leetcode.findallkdistantindicesinanarray

class FindAllKDistantIndicesInAnArray {
    class Solution {
        fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> =
            nums
                .withIndex()
                .filter { it.value == key }
                .flatMap { (index, _) ->
                    (-k..k).map { (it + index).coerceAtLeast(0).coerceAtMost(nums.lastIndex) }
                }
                .toSet()
                .sorted()
    }
}

package me.bossm0n5t3r.leetcode.findthelargestalmostmissinginteger

class FindTheLargestAlmostMissingInteger {
    class Solution {
        fun largestInteger(nums: IntArray, k: Int): Int {
            val frequency = mutableMapOf<Int, Int>().withDefault { 0 }
            val subarray = ArrayDeque<Int>()
            repeat(k) { subarray.addLast(nums[it]) }
            for (i in k..nums.size) {
                val visited = mutableSetOf<Int>()
                for (num in subarray) {
                    if (num !in visited) {
                        visited += num
                        frequency[num] = frequency.getValue(num) + 1
                    }
                }
                if (i == nums.size) break
                subarray.removeFirstOrNull()
                subarray.addLast(nums[i])
            }
            val candidates = frequency.filterValues { it == 1 }
            return if (candidates.isEmpty()) -1 else candidates.keys.max()
        }
    }
}

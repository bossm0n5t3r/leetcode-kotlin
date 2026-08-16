package me.bossm0n5t3r.leetcode.topkfrequentelements

class TopKFrequentElements {
    class Solution {
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val frequency = nums.toList().groupingBy { it }.eachCount()
            val bucket = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
            for ((num, count) in frequency) {
                bucket[count].add(num)
            }
            val result = mutableListOf<Int>()
            for (count in nums.size downTo 1) {
                for (num in bucket[count]) {
                    result.add(num)
                    if (result.size == k) return result.toIntArray()
                }
            }
            return result.toIntArray()
        }
    }
}

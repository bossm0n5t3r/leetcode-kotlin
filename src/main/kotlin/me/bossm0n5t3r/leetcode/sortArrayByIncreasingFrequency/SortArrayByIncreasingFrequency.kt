package me.bossm0n5t3r.leetcode.sortArrayByIncreasingFrequency

class SortArrayByIncreasingFrequency {
    class Solution {
        fun frequencySort(nums: IntArray): IntArray =
            nums
                .groupBy { it }
                .values
                .sortedWith(
                    compareBy<List<Int>> { it.size }.then(compareByDescending { it.first() })
                )
                .flatten()
                .toIntArray()
    }
}

package me.bossm0n5t3r.leetcode.mergeintervals

class MergeIntervals {
    class Solution {
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            val sorted = intervals.sortedBy { it[0] }
            val result = mutableListOf<IntArray>()
            for (interval in sorted) {
                if (result.isEmpty() || result.last()[1] < interval[0]) {
                    result += interval
                } else {
                    val lastElement = result.last()
                    lastElement[1] = maxOf(lastElement[1], interval[1])
                }
            }
            return result.toTypedArray()
        }
    }
}

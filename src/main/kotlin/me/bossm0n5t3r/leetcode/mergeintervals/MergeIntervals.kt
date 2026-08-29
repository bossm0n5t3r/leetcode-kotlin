package me.bossm0n5t3r.leetcode.mergeintervals

class MergeIntervals {
    class Solution {
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            val n = intervals.size
            val sorted =
                intervals.sortedWith(compareBy<IntArray> { it.first() }.thenComparing { it.last() })
            val result = mutableListOf<IntArray>()
            var index = 0
            while (index < n) {
                val cur = sorted[index++]
                if (result.isEmpty()) {
                    result += cur
                    continue
                }
                val (lastStart, lastEnd) = result[result.lastIndex]
                val (curStart, curEnd) = cur
                when {
                    lastEnd < curStart -> result += cur
                    else -> {
                        result[result.lastIndex][0] = minOf(lastStart, curStart)
                        result[result.lastIndex][1] = maxOf(lastEnd, curEnd)
                    }
                }
            }
            return result.toTypedArray()
        }
    }
}

package me.bossm0n5t3r.leetcode.nonoverlappingintervals

class NonOverlappingIntervals {
    class Solution {
        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            val sortedIntervals =
                intervals.map { it[0] to it[1] }.sortedWith(compareBy({ it.first }, { it.second }))
            var prevEnd = sortedIntervals[0].second
            var removedCount = 0
            for (i in 1 until sortedIntervals.size) {
                val current = sortedIntervals[i]
                prevEnd =
                    if (current.first < prevEnd) {
                        removedCount++
                        minOf(prevEnd, current.second)
                    } else {
                        current.second
                    }
            }
            return removedCount
        }
    }
}

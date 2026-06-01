package me.bossm0n5t3r.leetcode.nonOverlappingIntervals

class NonOverlappingIntervals {
    class Solution {
        fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
            val sortedIntervals =
                intervals.map { it[0] to it[1] }.sortedWith(compareBy({ it.first }, { it.second }))
            var left = sortedIntervals[0].second
            var result = 0
            for (i in 1 until sortedIntervals.size) {
                val right = sortedIntervals[i]
                left =
                    if (right.first < left) {
                        result += 1
                        minOf(left, right.second)
                    } else {
                        maxOf(left, right.second)
                    }
            }
            return result
        }
    }
}

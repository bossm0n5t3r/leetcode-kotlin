package me.bossm0n5t3r.leetcode.removecoveredintervals

class RemoveCoveredIntervals {
    class Solution {
        fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
            val n = intervals.size
            val sorted =
                intervals.sortedWith(
                    compareBy<IntArray> { it.first() }.thenByDescending { it.last() }
                )
            var result = 0
            var index = 0
            while (index < n) {
                val cur = sorted[index++]
                result++
                while (index < n && cur isCover sorted[index]) {
                    index++
                }
            }
            return result
        }

        private infix fun IntArray.isCover(other: IntArray): Boolean {
            val (a, b) = this
            val (c, d) = other
            return a <= c && d <= b
        }
    }
}

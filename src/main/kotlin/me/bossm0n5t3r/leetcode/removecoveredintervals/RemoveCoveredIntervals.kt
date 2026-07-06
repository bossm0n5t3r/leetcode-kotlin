package me.bossm0n5t3r.leetcode.removecoveredintervals

class RemoveCoveredIntervals {
    class Solution {
        fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
            intervals.sortWith { a, b ->
                if (a[0] != b[0]) a[0].compareTo(b[0]) else b[1].compareTo(a[1])
            }

            var result = 0
            var index = 0
            val n = intervals.size
            while (index < n) {
                val curStart = intervals[index][0]
                val curEnd = intervals[index][1]
                result++
                index++
                while (
                    index < n && curStart <= intervals[index][0] && intervals[index][1] <= curEnd
                ) {
                    index++
                }
            }
            return result
        }
    }
}

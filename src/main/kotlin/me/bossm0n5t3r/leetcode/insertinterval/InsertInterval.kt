package me.bossm0n5t3r.leetcode.insertinterval

class InsertInterval {
    class Solution {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val result = mutableListOf<IntArray>()
            var index = 0
            while (index < intervals.size) {
                val interval = intervals[index++]
                val (start, end) = interval
                when {
                    end < newInterval[0] -> result += interval
                    start <= newInterval[1] -> {
                        newInterval[0] = minOf(newInterval[0], start)
                        newInterval[1] = maxOf(newInterval[1], end)
                    }
                    else -> {
                        result += newInterval
                        result += interval
                        while (index < intervals.size) result += intervals[index++]
                    }
                }
            }
            if (result.isEmpty() || result.last()[1] < newInterval[0]) result += newInterval
            return result.toTypedArray()
        }
    }
}

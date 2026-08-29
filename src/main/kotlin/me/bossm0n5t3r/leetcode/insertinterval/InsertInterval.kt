package me.bossm0n5t3r.leetcode.insertinterval

class InsertInterval {
    class Solution {
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val n = intervals.size
            val result = mutableListOf<IntArray>()

            var (newStart, newEnd) = newInterval
            var index = 0

            while (index < n && intervals[index][1] < newStart) {
                result += intervals[index++]
            }

            while (index < n && intervals[index][0] <= newEnd) {
                newStart = minOf(newStart, intervals[index][0])
                newEnd = maxOf(newEnd, intervals[index][1])
                index++
            }

            result += intArrayOf(newStart, newEnd)

            while (index < n) {
                result += intervals[index++]
            }

            return result.toTypedArray()
        }
    }
}

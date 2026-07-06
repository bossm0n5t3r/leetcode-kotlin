package me.bossm0n5t3r.leetcode.removecoveredintervals

import java.util.PriorityQueue

class RemoveCoveredIntervals {
    class Solution {
        fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
            val pq: PriorityQueue<IntArray> =
                PriorityQueue(compareBy<IntArray> { it.first() }.thenByDescending { it.last() })
            pq.addAll(intervals)
            var result = 0
            while (pq.isNotEmpty()) {
                val cur = pq.poll()
                result++
                while (pq.isNotEmpty() && cur isCover pq.peek()) {
                    pq.poll()
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

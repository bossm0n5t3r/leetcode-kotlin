package me.bossm0n5t3r.leetcode.minimumoperationstoexceedthresholdvalueii

import java.util.PriorityQueue

class MinimumOperationsToExceedThresholdValueII {
    class Solution {
        fun minOperations(nums: IntArray, k: Int): Int {
            val pq =
                PriorityQueue<Long>(compareBy { it }).apply { addAll(nums.map { it.toLong() }) }
            var operation = 0
            while (pq.peek() < k) {
                val (x, y) = pq.poll() to pq.poll()
                pq.offer(minOf(x, y) * 2 + maxOf(x, y))
                operation++
            }
            return operation
        }
    }
}

package me.bossm0n5t3r.leetcode.longestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit

import java.util.PriorityQueue

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    class Solution {
        fun longestSubarray(nums: IntArray, limit: Int): Int {
            val continuousSubArrayWithMaxAndMin = ContinuousSubArrayWithMaxAndMin(limit)
            var l = 0
            var r = 0
            while (r < nums.size) {
                while (r < nums.size && continuousSubArrayWithMaxAndMin.isValid()) {
                    continuousSubArrayWithMaxAndMin.add(nums[r++])
                }
                while (l < r && continuousSubArrayWithMaxAndMin.isValid().not()) {
                    continuousSubArrayWithMaxAndMin.remove(nums[l++])
                }
            }
            return continuousSubArrayWithMaxAndMin.longestSubArrayLength
        }

        class ContinuousSubArrayWithMaxAndMin(private val limit: Int) {
            private var count = 0
            private val naturalOrderPQ = PriorityQueue(compareBy<Int> { it })
            private val reverseOrderPQ = PriorityQueue(compareByDescending<Int> { it })
            var longestSubArrayLength = 0

            fun isValid(): Boolean =
                if (naturalOrderPQ.isEmpty() || reverseOrderPQ.isEmpty()) {
                    true
                } else {
                    reverseOrderPQ.peek() - naturalOrderPQ.peek() <= limit
                }

            fun add(num: Int) {
                naturalOrderPQ.offer(num)
                reverseOrderPQ.offer(num)
                count++
                if (this.isValid()) {
                    longestSubArrayLength = maxOf(longestSubArrayLength, count)
                }
            }

            fun remove(num: Int) {
                naturalOrderPQ.remove(num)
                reverseOrderPQ.remove(num)
                count--
                if (this.isValid()) {
                    longestSubArrayLength = maxOf(longestSubArrayLength, count)
                }
            }
        }
    }
}

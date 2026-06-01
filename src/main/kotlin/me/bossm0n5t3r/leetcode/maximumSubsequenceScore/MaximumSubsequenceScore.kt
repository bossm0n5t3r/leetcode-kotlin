package me.bossm0n5t3r.leetcode.maximumSubsequenceScore

import java.util.PriorityQueue

class MaximumSubsequenceScore {
    class Solution {
        fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
            val n = nums1.size
            val zippedTwoNumsWithSorting =
                nums1
                    .zip(nums2)
                    .map { it.first.toLong() to it.second.toLong() }
                    .sortedBy { it.second }
            if (k == 1) {
                return zippedTwoNumsWithSorting.maxOf { it.first * it.second }
            }
            val pq = PriorityQueue<Long>()
            var (answer, sum) = 0L to 0L

            for (i in n - 1 downTo 0) {
                val num1 = zippedTwoNumsWithSorting[i].first
                if (i <= n - k) {
                    val cur = (sum + num1) * zippedTwoNumsWithSorting[i].second
                    answer = maxOf(answer, cur)
                }
                if (pq.size < k - 1) {
                    pq.offer(num1)
                    sum += num1
                } else if (num1 > pq.peek()) {
                    sum -= pq.poll()
                    sum += num1
                    pq.offer(num1)
                }
            }
            return answer
        }
    }
}

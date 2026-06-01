package me.bossm0n5t3r.leetcode.kthLargestElementInAnArray

import java.util.PriorityQueue

class KthLargestElementInAnArray {
    class Solution {
        fun findKthLargest(nums: IntArray, k: Int): Int {
            val pq = PriorityQueue<Int> { e1, e2 -> e2 - e1 }
            for (num in nums) {
                pq.offer(num)
            }
            repeat(k - 1) { pq.poll() }
            return pq.peek()
        }
    }
}

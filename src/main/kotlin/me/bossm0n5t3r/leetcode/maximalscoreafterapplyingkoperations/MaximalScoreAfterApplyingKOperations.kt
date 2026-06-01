package me.bossm0n5t3r.leetcode.maximalscoreafterapplyingkoperations

import java.util.PriorityQueue

class MaximalScoreAfterApplyingKOperations {
    class Solution {
        fun maxKelements(nums: IntArray, k: Int): Long {
            val pq =
                PriorityQueue<Int>(compareByDescending { it }).also { it.addAll(nums.toList()) }
            var result = 0L
            var countK = k
            while (countK-- > 0) {
                val maxNum = pq.poll()
                result += maxNum
                pq.offer(ceil(maxNum / 3.0))
            }
            return result
        }

        private fun ceil(num: Double): Int =
            num.takeIf { it == it.toInt().toDouble() || it < 0 }?.toInt() ?: (num + 1).toInt()
    }
}

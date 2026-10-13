package me.bossm0n5t3r.leetcode.maximumalternatingsumofsquares

class MaximumAlternatingSumOfSquares {
    class Solution {
        fun maxAlternatingSum(nums: IntArray): Long {
            val squares = nums.map { it.toLong() * it }.sorted()

            val half = nums.size / 2
            var result = 0L

            for (i in squares.indices) {
                result += if (i < half) -squares[i] else squares[i]
            }

            return result
        }
    }
}

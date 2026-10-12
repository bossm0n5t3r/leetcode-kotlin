package me.bossm0n5t3r.leetcode.applyoperationsonarraytomaximizesumofsquares

class ApplyOperationsOnArrayToMaximizeSumOfSquares {
    class Solution {
        fun maxSum(nums: List<Int>, k: Int): Int {
            val mod = 1_000_000_007L
            val bitCount = IntArray(Int.SIZE_BITS - 1)

            for (num in nums) {
                for (bit in 0 until Int.SIZE_BITS - 1) {
                    if ((num and (1 shl bit)) != 0) {
                        bitCount[bit]++
                    }
                }
            }

            var answer = 0L

            repeat(k) {
                var value = 0L

                for (bit in 0 until Int.SIZE_BITS - 1) {
                    if (bitCount[bit] > 0) {
                        value += 1L shl bit
                        bitCount[bit]--
                    }
                }

                answer = (answer + value * value) % mod
            }

            return answer.toInt()
        }
    }
}

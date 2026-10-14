package me.bossm0n5t3r.leetcode.maximizesumofsquaresofdigits

class MaximizeSumOfSquaresOfDigits {
    class Solution {
        fun maxSumOfSquares(num: Int, sum: Int): String {
            if (sum > num * 9) return ""
            var remaining = sum
            val result = StringBuilder()
            repeat(num) {
                val digit = minOf(9, remaining)
                result.append(digit)
                remaining -= digit
            }
            return result.toString()
        }
    }
}

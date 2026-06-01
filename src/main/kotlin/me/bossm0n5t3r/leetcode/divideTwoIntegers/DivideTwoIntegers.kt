package me.bossm0n5t3r.leetcode.divideTwoIntegers

class DivideTwoIntegers {
    class Solution {
        fun divide(dividend: Int, divisor: Int): Int {
            if (dividend == 1 shl 31 && divisor == -1) return Int.MAX_VALUE
            var result = 0
            var tmpDividend = abs(dividend)
            val tmpDivisor = abs(divisor)
            (31 downTo 0).forEach { i ->
                if ((tmpDividend shr i) - tmpDivisor >= 0) {
                    result += (1 shl i)
                    tmpDividend -= (tmpDivisor shl i)
                }
            }
            return if (dividend > 0 == divisor > 0) {
                result
            } else {
                0 - result
            }
        }

        private fun abs(a: Int) =
            if (a >= 0) {
                a.toLong()
            } else {
                0L - a.toLong()
            }
    }
}

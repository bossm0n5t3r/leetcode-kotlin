package me.bossm0n5t3r.leetcode.numberOfCommonFactors

class NumberOfCommonFactors {
    class Solution {
        fun commonFactors(a: Int, b: Int): Int {
            val gcd = gcd(a, b)
            var factor = 1
            var result = 0
            while (factor * factor <= gcd) {
                if (gcd % factor == 0) {
                    result += if (factor * factor == gcd) 1 else 2
                }
                factor++
            }
            return result
        }

        private fun gcd(x: Int, y: Int): Int {
            if (y != 0) {
                return gcd(y, x % y)
            }
            return x
        }
    }
}

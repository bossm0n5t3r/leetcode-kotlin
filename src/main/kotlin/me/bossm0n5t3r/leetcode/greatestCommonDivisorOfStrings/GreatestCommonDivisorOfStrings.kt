package me.bossm0n5t3r.leetcode.greatestCommonDivisorOfStrings

class GreatestCommonDivisorOfStrings {
    class Solution {
        fun gcdOfStrings(str1: String, str2: String): String {
            if (str1 + str2 != str2 + str1) return ""
            val gcd = gcd(str1.length, str2.length)
            return str1.substring(0, gcd)
        }

        private fun gcd(x: Int, y: Int): Int {
            if (x == 0) return y
            return gcd(y % x, x)
        }
    }
}

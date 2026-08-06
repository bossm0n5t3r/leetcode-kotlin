package me.bossm0n5t3r.leetcode.smallestdivisibledigitproducti

class SmallestDivisibleDigitProductI {
    class Solution {
        fun smallestNumber(n: Int, t: Int): Int {
            var result = n
            while (true) {
                val productOfDigits = productOfDigits(result)
                if (productOfDigits % t == 0) return result
                result++
            }
        }

        private fun productOfDigits(n: Int): Int {
            return n.toString().fold(1) { acc, ch -> acc * ch.digitToInt() }
        }
    }
}

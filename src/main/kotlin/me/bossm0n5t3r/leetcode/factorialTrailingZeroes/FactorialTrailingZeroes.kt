package me.bossm0n5t3r.leetcode.factorialTrailingZeroes

class FactorialTrailingZeroes {
    class Solution {
        fun trailingZeroes(n: Int): Int {
            val multiplesOf2UnderN = getMultiplesOfMUnderN(n, 2)
            val multiplesOf5UnderN = getMultiplesOfMUnderN(n, 5)
            var numOfFactor2 = 0
            var numOfFactor5 = 0
            multiplesOf2UnderN.forEach { numOfFactor2 += n / it }
            multiplesOf5UnderN.forEach { numOfFactor5 += n / it }
            return if (numOfFactor2 <= numOfFactor5) numOfFactor2 else numOfFactor5
        }

        private fun getMultiplesOfMUnderN(n: Int, m: Int): List<Int> {
            if (n < m) return emptyList()
            val result = mutableListOf<Int>()
            var cur = m
            while (cur <= n) {
                result.add(cur)
                cur *= m
            }
            return result
        }
    }
}

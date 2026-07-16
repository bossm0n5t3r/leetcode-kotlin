package me.bossm0n5t3r.leetcode.sumofgcdofformedpairs

class SumOfGCDOfFormedPairs {
    class Solution {
        fun gcdSum(nums: IntArray): Long {
            var mx = 0
            val prefixGcd = mutableListOf<Int>()
            for (num in nums) {
                mx = maxOf(mx, num)
                prefixGcd += gcd(mx, num)
            }
            prefixGcd.sort()
            var result = 0L
            while (prefixGcd.size > 1) {
                val first = prefixGcd.removeFirst()
                val last = prefixGcd.removeLast()
                result += gcd(first, last)
            }
            return result
        }

        private fun gcd(a: Int, b: Int): Int {
            var x = a
            var y = b
            while (y != 0) {
                val temp = x
                x = y
                y = temp % y
            }
            return x
        }
    }
}

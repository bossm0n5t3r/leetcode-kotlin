package me.bossm0n5t3r.leetcode.findgreatestcommondivisorofarray

class FindGreatestCommonDivisorOfArray {
    class Solution {
        fun findGCD(nums: IntArray): Int {
            nums.sort()
            return gcd(nums.first(), nums.last())
        }

        private fun gcd(a: Int, b: Int): Int {
            var x = a
            var y = b
            while (y != 0) {
                val tmp = x
                x = y
                y = tmp % y
            }
            return x
        }
    }
}

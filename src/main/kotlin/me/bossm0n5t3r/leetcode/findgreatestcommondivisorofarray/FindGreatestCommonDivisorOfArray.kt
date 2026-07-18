package me.bossm0n5t3r.leetcode.findgreatestcommondivisorofarray

class FindGreatestCommonDivisorOfArray {
    class Solution {
        fun findGCD(nums: IntArray): Int {
            var min = nums[0]
            var max = nums[0]
            for (num in nums) {
                if (num < min) min = num
                if (num > max) max = num
            }
            return gcd(min, max)
        }

        private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    }
}

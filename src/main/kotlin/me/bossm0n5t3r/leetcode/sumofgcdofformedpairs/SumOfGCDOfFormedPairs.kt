package me.bossm0n5t3r.leetcode.sumofgcdofformedpairs

class SumOfGCDOfFormedPairs {
    class Solution {
        fun gcdSum(nums: IntArray): Long {
            val n = nums.size
            val prefixGcd = IntArray(n)
            var mx = 0
            for (i in 0 until n) {
                val num = nums[i]
                mx = maxOf(mx, num)
                prefixGcd[i] = gcd(mx, num)
            }
            prefixGcd.sort()

            var result = 0L
            var left = 0
            var right = n - 1
            while (left < right) {
                result += gcd(prefixGcd[left], prefixGcd[right])
                left++
                right--
            }
            return result
        }

        private fun gcd(a: Int, b: Int): Int {
            var x = a
            var y = b
            while (y != 0) {
                val temp = x % y
                x = y
                y = temp
            }
            return x
        }
    }
}

package me.bossm0n5t3r.leetcode.rotatefunction

class RotateFunction {
    class Solution {
        fun maxRotateFunction(nums: IntArray): Int {
            val n = nums.size
            var totalSum = 0L
            var fZero = 0L
            for (i in 0 until n) {
                totalSum += nums[i]
                fZero += i * nums[i]
            }
            var fNext = fZero
            var result = fZero
            for (i in 0 until n - 1) {
                fNext += totalSum - n * nums[n - 1 - i]
                result = maxOf(result, fNext)
            }
            return result.toInt()
        }
    }
}

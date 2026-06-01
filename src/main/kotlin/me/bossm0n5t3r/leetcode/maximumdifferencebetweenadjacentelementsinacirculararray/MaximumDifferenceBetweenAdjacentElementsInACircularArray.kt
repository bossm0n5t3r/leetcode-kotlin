package me.bossm0n5t3r.leetcode.maximumdifferencebetweenadjacentelementsinacirculararray

class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    class Solution {
        private fun abs(a: Int, b: Int) = if (a >= b) a - b else b - a

        fun maxAdjacentDistance(nums: IntArray): Int {
            var result = abs(nums.first(), nums.last())
            for (i in 1 until nums.size) {
                result = maxOf(result, abs(nums[i], nums[i - 1]))
            }
            return result
        }
    }
}

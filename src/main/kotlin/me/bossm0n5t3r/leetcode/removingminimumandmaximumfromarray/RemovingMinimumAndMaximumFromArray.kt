package me.bossm0n5t3r.leetcode.removingminimumandmaximumfromarray

class RemovingMinimumAndMaximumFromArray {
    class Solution {
        fun minimumDeletions(nums: IntArray): Int {
            val n = nums.size

            var minIndex = 0
            var maxIndex = 0

            for (i in nums.indices) {
                if (nums[i] < nums[minIndex]) minIndex = i
                if (nums[i] > nums[maxIndex]) maxIndex = i
            }

            val left = minOf(minIndex, maxIndex)
            val right = maxOf(minIndex, maxIndex)

            return minOf(right + 1, n - left, left + 1 + n - right)
        }
    }
}

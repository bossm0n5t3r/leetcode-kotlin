package me.bossm0n5t3r.leetcode.findPeakElement

class FindPeakElement {
    class Solution {
        fun findPeakElement(nums: IntArray): Int = binarySearch(nums, 0, nums.size - 1)

        @Suppress("ReturnCount")
        private fun binarySearch(nums: IntArray, start: Int, end: Int): Int {
            if (start > end) return -1
            if (start == end) return start
            if (start + 1 == end) return if (nums[start] > nums[end]) start else end
            val mid = (start + end) / 2

            val left = binarySearch(nums, start, mid)
            val right = binarySearch(nums, mid + 1, end)

            return if (nums[left] > nums[right]) {
                left
            } else {
                right
            }
        }
    }
}

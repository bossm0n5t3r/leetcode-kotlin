package me.bossm0n5t3r.leetcode.maximumcountofpositiveintegerandnegativeinteger

class MaximumCountOfPositiveIntegerAndNegativeInteger {
    class Solution {
        fun maximumCount(nums: IntArray): Int {
            val firstZeroIndex = findFirstIndex(nums, 0)
            val firstOneIndex = findFirstIndex(nums, 1)

            return maxOf(firstZeroIndex, nums.size - firstOneIndex)
        }

        private fun findFirstIndex(nums: IntArray, target: Int): Int {
            var left = 0
            var right = nums.size

            while (left < right) {
                val mid = left + (right - left) / 2
                if (nums[mid] >= target) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }

            return left
        }
    }
}

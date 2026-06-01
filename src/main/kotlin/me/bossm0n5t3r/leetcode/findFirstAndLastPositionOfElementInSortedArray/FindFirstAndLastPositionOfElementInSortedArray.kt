package me.bossm0n5t3r.leetcode.findFirstAndLastPositionOfElementInSortedArray

class FindFirstAndLastPositionOfElementInSortedArray {
    class Solution {
        fun searchRange(nums: IntArray, target: Int): IntArray {
            if (nums.isEmpty()) return intArrayOf(-1, -1)
            val tmp = bisect(nums, 0, nums.size - 1, target)
            if (tmp == -1) return intArrayOf(-1, -1)
            var low = tmp
            var high = tmp
            while (low >= 1 && nums[low - 1] == target) low--
            while (high + 1 < nums.size && nums[high + 1] == target) high++
            return intArrayOf(low, high)
        }

        private fun bisect(nums: IntArray, low: Int, high: Int, target: Int): Int {
            while (low <= high) {
                val mid = low + (high - low) / 2
                return if (nums[mid] > target) {
                    bisect(nums, low, mid - 1, target)
                } else if (nums[mid] < target) {
                    bisect(nums, mid + 1, high, target)
                } else {
                    mid
                }
            }
            return -1
        }
    }
}

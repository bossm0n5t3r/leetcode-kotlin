package me.bossm0n5t3r.leetcode.searchInsertPosition

class SearchInsertPosition {
    class Solution {
        fun searchInsert(nums: IntArray, target: Int): Int {
            var (left, right) = 0 to nums.size - 1
            while (left <= right) {
                val mid = (left + right) / 2
                when {
                    nums[mid] == target -> return mid
                    nums[mid] < target -> left = mid + 1
                    else -> right = mid - 1
                }
            }
            return left
        }
    }
}

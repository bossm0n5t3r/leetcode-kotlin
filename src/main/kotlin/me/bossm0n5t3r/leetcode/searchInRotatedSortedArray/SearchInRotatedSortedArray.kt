package me.bossm0n5t3r.leetcode.searchInRotatedSortedArray

class SearchInRotatedSortedArray {
    class Solution {
        fun search(nums: IntArray, target: Int): Int {
            var diff = 0
            val max = nums[diff]
            for (i in nums.indices) {
                if (max < nums[i]) {
                    diff = i
                }
            }
            var low = diff + 1
            var high = nums.size + diff
            while (low <= high) {
                val mid = low + (high - low) / 2
                if (nums[(mid + nums.size) % nums.size] == target) {
                    return (mid + nums.size) % nums.size
                }
                if (target < nums[(mid + nums.size) % nums.size]) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            }
            return -1
        }
    }
}

package me.bossm0n5t3r.leetcode.sortColors

class SortColors {
    class Solution {
        fun sortColors(nums: IntArray) {
            var twoEnd = nums.lastIndex
            var start = 0
            while (start <= twoEnd) {
                while (start <= twoEnd && nums[start] == 2) {
                    swap(nums, start, twoEnd--)
                }
                start++
            }
            var oneEnd = twoEnd
            start = 0
            while (start <= oneEnd) {
                while (start <= oneEnd && nums[start] == 1) {
                    swap(nums, start, oneEnd--)
                }
                start++
            }
        }

        private fun swap(nums: IntArray, i: Int, j: Int) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
        }
    }
}

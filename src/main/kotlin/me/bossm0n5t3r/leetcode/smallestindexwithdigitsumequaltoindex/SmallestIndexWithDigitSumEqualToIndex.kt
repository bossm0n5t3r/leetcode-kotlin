package me.bossm0n5t3r.leetcode.smallestindexwithdigitsumequaltoindex

class SmallestIndexWithDigitSumEqualToIndex {
    class Solution {
        fun smallestIndex(nums: IntArray): Int {
            return nums.indices.firstOrNull { index -> index == nums[index].digitSum() } ?: -1
        }

        private fun Int.digitSum(): Int {
            var result = 0
            var tmp = this
            while (tmp > 0) {
                result += (tmp % 10)
                tmp /= 10
            }
            return result
        }
    }
}

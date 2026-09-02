package me.bossm0n5t3r.leetcode.constructuniformparityarrayii

class ConstructUniformParityArrayII {
    class Solution {
        fun uniformArray(nums1: IntArray): Boolean {
            var minOdd = Int.MAX_VALUE
            for (num in nums1) {
                if (num % 2 == 1) {
                    minOdd = minOf(minOdd, num)
                }
            }
            return canMakeUniformArray(nums1, minOdd, true) ||
                canMakeUniformArray(nums1, minOdd, false)
        }

        private fun canMakeUniformArray(nums: IntArray, minOdd: Int, makeOdd: Boolean): Boolean {
            for (num in nums) {
                val isOdd = num % 2 == 1
                if (isOdd == makeOdd) continue
                if (!makeOdd || num <= minOdd) return false
            }
            return true
        }
    }
}

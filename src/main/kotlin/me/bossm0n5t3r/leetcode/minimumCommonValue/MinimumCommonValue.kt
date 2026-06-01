package me.bossm0n5t3r.leetcode.minimumCommonValue

class MinimumCommonValue {
    class Solution {
        fun getCommon(nums1: IntArray, nums2: IntArray): Int {
            var num1Idx = 0
            var num2Idx = 0

            while (num1Idx < nums1.size && num2Idx < nums2.size) {
                if (nums1[num1Idx] == nums2[num2Idx]) {
                    return nums1[num1Idx]
                }

                if (nums1[num1Idx] < nums2[num2Idx]) {
                    num1Idx++
                } else {
                    num2Idx++
                }
            }

            return -1
        }
    }
}

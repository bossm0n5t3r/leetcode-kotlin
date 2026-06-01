package me.bossm0n5t3r.leetcode.findTheDifferenceOfTwoArrays

class FindTheDifferenceOfTwoArrays {
    class Solution {
        fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
            val nums1Set = nums1.toSet()
            val nums2Set = nums2.toSet()
            return listOf((nums1Set - nums2Set).toList(), (nums2Set - nums1Set).toList())
        }
    }
}

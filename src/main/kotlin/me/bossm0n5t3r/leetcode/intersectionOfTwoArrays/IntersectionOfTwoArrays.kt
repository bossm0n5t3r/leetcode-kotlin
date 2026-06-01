package me.bossm0n5t3r.leetcode.intersectionOfTwoArrays

class IntersectionOfTwoArrays {
    class Solution {
        fun intersection(nums1: IntArray, nums2: IntArray): IntArray =
            nums1.toSet().intersect(nums2.toSet()).toIntArray()
    }
}

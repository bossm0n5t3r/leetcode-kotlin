package me.bossm0n5t3r.leetcode.intersectionOfTwoArraysII

class IntersectionOfTwoArraysII {
    class Solution {
        fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            val count = IntArray(1001)
            for (num in nums1) {
                count[num]++
            }
            val result = mutableListOf<Int>()
            for (num in nums2) {
                if (count[num] > 0) {
                    result.add(num)
                    count[num]--
                }
            }
            return result.toIntArray()
        }
    }
}

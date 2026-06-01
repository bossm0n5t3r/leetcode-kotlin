package me.bossm0n5t3r.leetcode.intersectionOfTwoArrays2

class IntersectionOfTwoArrays2 {
    class Solution {
        fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            val result = mutableListOf<Int>()
            val map1 = mutableMapOf<Int, Int>()
            nums1.forEach { map1[it] = map1.getOrDefault(it, 0) + 1 }
            nums2.forEach {
                val count = map1.getOrDefault(it, 0)
                if (count > 0) {
                    result.add(it)
                    map1[it] = count - 1
                }
            }
            return result.toIntArray()
        }
    }
}

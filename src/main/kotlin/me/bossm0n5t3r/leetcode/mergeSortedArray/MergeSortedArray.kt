package me.bossm0n5t3r.leetcode.mergeSortedArray

class MergeSortedArray {
    class Solution {
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
            var i = m - 1
            var j = n - 1
            var k = m + n - 1

            while (j >= 0) {
                nums1[k--] =
                    if (i >= 0 && nums1[i] > nums2[j]) {
                        nums1[i--]
                    } else {
                        nums2[j--]
                    }
            }
        }
    }
}

package me.bossm0n5t3r.leetcode.mergetwo2darraysbysummingvalues

class MergeTwo2dArraysBySummingValues {
    class Solution {
        fun mergeArrays(
            nums1: Array<IntArray>,
            nums2: Array<IntArray>,
        ): Array<IntArray> {
            val result = mutableListOf<IntArray>()
            var nums1Index = 0
            var nums2Index = 0
            while (nums1Index < nums1.size && nums2Index < nums2.size) {
                val (curNum1Id, curNum1Value) = nums1[nums1Index]
                val (curNum2Id, curNum2Value) = nums2[nums2Index]
                when {
                    curNum1Id == curNum2Id -> {
                        result += intArrayOf(curNum1Id, (curNum1Value + curNum2Value))
                        nums1Index++
                        nums2Index++
                    }

                    curNum1Id > curNum2Id -> {
                        result += nums2[nums2Index]
                        nums2Index++
                    }

                    else -> {
                        result += nums1[nums1Index]
                        nums1Index++
                    }
                }
            }
            while (nums1Index < nums1.size) {
                result += nums1[nums1Index++]
            }
            while (nums2Index < nums2.size) {
                result += nums2[nums2Index++]
            }
            return result.toTypedArray()
        }
    }
}

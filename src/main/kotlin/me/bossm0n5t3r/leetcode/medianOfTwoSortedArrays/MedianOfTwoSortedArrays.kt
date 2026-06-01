package me.bossm0n5t3r.leetcode.medianOfTwoSortedArrays

class MedianOfTwoSortedArrays {
    class Solution {
        data class ArrayData(val nums1: IntArray, val nums2: IntArray) {
            var idxNum1: Int = 0
            var idxNum2: Int = 0

            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as ArrayData

                if (!nums1.contentEquals(other.nums1)) return false
                if (!nums2.contentEquals(other.nums2)) return false
                if (idxNum1 != other.idxNum1) return false
                if (idxNum2 != other.idxNum2) return false

                return true
            }

            override fun hashCode(): Int {
                var result = nums1.contentHashCode()
                result = 31 * result + nums2.contentHashCode()
                result = 31 * result + idxNum1
                result = 31 * result + idxNum2
                return result
            }

            fun next(): Int {
                if (idxNum1 == nums1.size) {
                    return nums2[idxNum2++]
                }
                if (idxNum2 == nums2.size) {
                    return nums1[idxNum1++]
                }
                return if (nums1[idxNum1] <= nums2[idxNum2]) {
                    nums1[idxNum1++]
                } else {
                    nums2[idxNum2++]
                }
            }
        }

        fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
            val totalLength = nums1.size + nums2.size
            val arrayData = ArrayData(nums1, nums2)

            return if (totalLength % 2 == 0) {
                repeat(totalLength / 2 - 1) { arrayData.next() }
                (arrayData.next() + arrayData.next()) / 2.0
            } else {
                repeat(totalLength / 2) { arrayData.next() }
                arrayData.next().toDouble()
            }
        }
    }
}

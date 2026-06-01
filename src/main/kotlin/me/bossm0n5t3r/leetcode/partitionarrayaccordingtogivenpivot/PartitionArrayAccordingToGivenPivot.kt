package me.bossm0n5t3r.leetcode.partitionarrayaccordingtogivenpivot

class PartitionArrayAccordingToGivenPivot {
    class Solution {
        fun pivotArray(nums: IntArray, pivot: Int): IntArray {
            var (less, equal) = 0 to 0
            for (num in nums) {
                when {
                    num < pivot -> less++
                    num == pivot -> equal++
                }
            }
            val result = IntArray(nums.size)
            var lessIndex = 0
            var equalIndex = less
            var greaterIndex = less + equal
            for (num in nums) {
                when {
                    num < pivot -> result[lessIndex++] = num
                    num > pivot -> result[greaterIndex++] = num
                    else -> result[equalIndex++] = num
                }
            }
            return result
        }
    }
}

package me.bossm0n5t3r.leetcode.removingminimumandmaximumfromarray

class RemovingMinimumAndMaximumFromArray {
    class Solution {
        fun minimumDeletions(nums: IntArray): Int {
            val n = nums.size
            if (n <= 2) return n

            var minValue = Int.MAX_VALUE
            var maxValue = Int.MIN_VALUE

            var minIndex = -1
            var maxIndex = -1

            for (i in nums.indices) {
                val num = nums[i]
                if (num < minValue) {
                    minValue = num
                    minIndex = i
                }
                if (maxValue < num) {
                    maxValue = num
                    maxIndex = i
                }
            }

            val deleteFrontMin = minIndex + 1
            val deleteFrontMax = maxIndex + 1
            val deleteBackMin = n - minIndex
            val deleteBackMax = n - maxIndex

            return minOf(
                minOf(deleteFrontMin, deleteFrontMax) + minOf(deleteBackMin, deleteBackMax),
                maxOf(deleteFrontMin, deleteFrontMax),
                maxOf(deleteBackMin, deleteBackMax),
            )
        }
    }
}

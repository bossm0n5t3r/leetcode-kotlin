package me.bossm0n5t3r.leetcode.distributeElementsIntoTwoArraysI

class DistributeElementsIntoTwoArraysI {
    class Solution {
        fun resultArray(nums: IntArray): IntArray {
            val arr1 = mutableListOf<Int>()
            val arr2 = mutableListOf<Int>()
            for (i in nums.indices) {
                val num = nums[i]
                selectArr(arr1, arr2).add(num)
            }
            return (arr1 + arr2).toIntArray()
        }

        private fun selectArr(arr1: MutableList<Int>, arr2: MutableList<Int>): MutableList<Int> =
            when {
                arr1.isEmpty() -> arr1
                arr2.isEmpty() -> arr2
                arr1.last() > arr2.last() -> arr1
                else -> arr2
            }
    }
}

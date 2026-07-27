package me.bossm0n5t3r.leetcode.maximumproductoftwoelementsinanarray

class MaximumProductOfTwoElementsInAnArray {
    class Solution {
        fun maxProduct(nums: IntArray): Int {
            var first = 0
            var second = 0
            for (num in nums) {
                when {
                    num > first -> {
                        second = first
                        first = num
                    }
                    num > second -> {
                        second = num
                    }
                }
            }
            return (first - 1) * (second - 1)
        }
    }
}

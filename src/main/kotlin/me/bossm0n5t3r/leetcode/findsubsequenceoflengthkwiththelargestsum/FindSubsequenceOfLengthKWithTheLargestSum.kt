package me.bossm0n5t3r.leetcode.findsubsequenceoflengthkwiththelargestsum

class FindSubsequenceOfLengthKWithTheLargestSum {
    class Solution {
        fun maxSubsequence(nums: IntArray, k: Int): IntArray {
            val sortedDescendingNums = nums.sortedDescending()
            val numberToCount = mutableMapOf<Int, Int>()
            repeat(k) {
                val key = sortedDescendingNums[it]
                numberToCount[key] = numberToCount.getOrElse(key) { 0 } + 1
            }

            val result = IntArray(k)
            var index = 0
            for (num in nums) {
                val value = numberToCount[num]
                if (value != null && value > 0) {
                    result[index++] = num
                    numberToCount[num] = value - 1
                }
            }

            return result
        }
    }
}

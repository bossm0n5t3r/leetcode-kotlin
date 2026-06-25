package me.bossm0n5t3r.leetcode.countsubarrayswithmajorityelementi

class CountSubarraysWithMajorityElementI {
    class Solution {
        fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
            var count = 0
            val n = nums.size
            for (i in 0 until n) {
                var currentSum = 0
                for (j in i until n) {
                    currentSum += if (nums[j] == target) 1 else -1
                    if (currentSum > 0) {
                        count++
                    }
                }
            }
            return count
        }
    }
}

package me.bossm0n5t3r.leetcode.smallestmissingintegergreaterthansequentialprefixsum

class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    class Solution {
        fun missingInteger(nums: IntArray): Int {
            var result = nums[0]
            for (i in 1 until nums.size) {
                if (nums[i] != nums[i - 1] + 1) break
                result += nums[i]
            }
            val numsSet = nums.toSet()
            while (result in numsSet) {
                result++
            }
            return result
        }
    }
}

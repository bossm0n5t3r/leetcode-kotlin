package me.bossm0n5t3r.leetcode.smallestmissingmultipleofk

class SmallestMissingMultipleOfK {
    class Solution {
        fun missingMultiple(nums: IntArray, k: Int): Int {
            val numsSet = nums.toSet()
            var result = k
            while (result in numsSet) {
                result += k
            }
            return result
        }
    }
}

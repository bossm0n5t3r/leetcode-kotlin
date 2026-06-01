package me.bossm0n5t3r.leetcode.minimumoperationstomakebinaryarrayelementsequaltoonei

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    class Solution {
        fun minOperations(nums: IntArray): Int {
            var count = 0
            for (i in 0 until nums.size - 2) {
                if (nums[i] == 1) {
                    continue
                }
                operation(nums, i)
                count++
            }
            return if (nums.any { it == 0 }) -1 else count
        }

        private fun operation(nums: IntArray, i: Int) {
            nums[i] = 1 - nums[i]
            nums[i + 1] = 1 - nums[i + 1]
            nums[i + 2] = 1 - nums[i + 2]
        }
    }
}

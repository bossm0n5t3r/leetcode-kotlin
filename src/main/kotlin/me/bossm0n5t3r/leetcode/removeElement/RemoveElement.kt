package me.bossm0n5t3r.leetcode.removeElement

class RemoveElement {
    class Solution {
        fun removeElement(nums: IntArray, `val`: Int): Int {
            var rootIndex = 0
            for (num in nums) {
                if (num != `val`) {
                    nums[rootIndex++] = num
                }
            }
            return rootIndex
        }
    }
}

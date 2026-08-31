package me.bossm0n5t3r.leetcode.houserobber

class HouseRobber {
    class Solution {
        fun rob(nums: IntArray): Int {
            val n = nums.size
            if (n == 1) return nums[0]
            var prev2 = 0
            var prev1 = 0
            for (i in 0 until n) {
                val current = maxOf(prev1, prev2 + nums[i])
                prev2 = prev1
                prev1 = current
            }
            return prev1
        }
    }
}

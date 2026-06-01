package me.bossm0n5t3r.leetcode.divideanarrayintosubarrayswithminimumcosti

class DivideAnArrayIntoSubarraysWithMinimumCostI {
    class Solution {
        fun minimumCost(nums: IntArray): Int {
            require(nums.size in 3..50)
            return nums.first() + nums.drop(1).sorted().take(2).sum()
        }
    }
}

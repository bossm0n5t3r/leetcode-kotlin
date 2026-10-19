package me.bossm0n5t3r.leetcode.findtargetindicesaftersortingarray

class FindTargetIndicesAfterSortingArray {
    class Solution {
        fun targetIndices(nums: IntArray, target: Int): List<Int> {
            return nums.sorted().withIndex().mapNotNull { (i, num) ->
                if (num == target) i else null
            }
        }
    }
}

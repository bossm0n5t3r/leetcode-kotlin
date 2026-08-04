package me.bossm0n5t3r.leetcode.findmissingelements

class FindMissingElements {
    class Solution {
        fun findMissingElements(nums: IntArray): List<Int> {
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            val numsSet = mutableSetOf<Int>()
            for (num in nums) {
                if (min > num) min = num
                if (max < num) max = num
                numsSet += num
            }
            return buildList {
                for (num in min..max) {
                    if (num !in numsSet) add(num)
                }
            }
        }
    }
}

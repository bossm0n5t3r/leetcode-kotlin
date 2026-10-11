package me.bossm0n5t3r.leetcode.sumofsquaresofspecialelements

class SumOfSquaresOfSpecialElements {
    class Solution {
        fun sumOfSquares(nums: IntArray): Int {
            val n = nums.size
            return nums.withIndex().sumOf { (index, num) ->
                if (n % (index + 1) != 0) return@sumOf 0
                num * num
            }
        }
    }
}

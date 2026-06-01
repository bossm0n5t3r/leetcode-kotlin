package me.bossm0n5t3r.leetcode.squaresOfASortedArray

class SquaresOfASortedArray {
    class Solution {
        fun sortedSquares(nums: IntArray): IntArray = nums.map { it * it }.sorted().toIntArray()
    }
}

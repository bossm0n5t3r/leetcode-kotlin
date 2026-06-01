package me.bossm0n5t3r.leetcode.largestnumber

class LargestNumber {
    class Solution {
        fun largestNumber(nums: IntArray): String =
            nums
                .map { it.toString() }
                .sortedWith { a, b -> (b + a).compareTo(a + b) }
                .takeIf { it.first() != "0" }
                ?.joinToString("") ?: "0"
    }
}

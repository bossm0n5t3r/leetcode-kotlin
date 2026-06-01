package me.bossm0n5t3r.leetcode.minimumlengthofstringafteroperations

class MinimumLengthOfStringAfterOperations {
    class Solution {
        fun minimumLength(s: String): Int =
            s.withIndex().groupBy { it.value }.values.map { if (it.size % 2 == 0) 2 else 1 }.sum()
    }
}

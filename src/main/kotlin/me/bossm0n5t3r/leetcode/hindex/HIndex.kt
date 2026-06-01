package me.bossm0n5t3r.leetcode.hindex

class HIndex {
    class Solution {
        fun hIndex(citations: IntArray): Int =
            citations.sorted().withIndex().maxOfOrNull { (index, value) ->
                value.coerceAtMost(citations.size - index)
            } ?: 0
    }
}

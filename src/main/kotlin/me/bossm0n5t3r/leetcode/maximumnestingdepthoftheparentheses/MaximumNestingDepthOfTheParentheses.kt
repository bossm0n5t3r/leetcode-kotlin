package me.bossm0n5t3r.leetcode.maximumnestingdepthoftheparentheses

class MaximumNestingDepthOfTheParentheses {
    class Solution {
        fun maxDepth(s: String): Int {
            var depth = 0
            var maxDepth = 0
            for (c in s) {
                depth +=
                    when (c) {
                        '(' -> 1
                        ')' -> -1
                        else -> 0
                    }
                if (depth > maxDepth) maxDepth = depth
            }
            return maxDepth
        }
    }
}

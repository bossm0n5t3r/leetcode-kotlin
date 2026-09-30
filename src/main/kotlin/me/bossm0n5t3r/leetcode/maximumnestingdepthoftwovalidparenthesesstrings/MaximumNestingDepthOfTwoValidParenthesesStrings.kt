package me.bossm0n5t3r.leetcode.maximumnestingdepthoftwovalidparenthesesstrings

class MaximumNestingDepthOfTwoValidParenthesesStrings {
    class Solution {
        fun maxDepthAfterSplit(seq: String): IntArray {
            val n = seq.length
            val result = IntArray(n)
            var depth = 0
            for (i in 0 until n) {
                if (seq[i] == '(') {
                    depth++
                    result[i] = depth % 2
                } else {
                    result[i] = depth % 2
                    depth--
                }
            }
            return result
        }
    }
}

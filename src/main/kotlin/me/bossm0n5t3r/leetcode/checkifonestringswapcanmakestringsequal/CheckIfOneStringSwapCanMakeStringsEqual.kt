package me.bossm0n5t3r.leetcode.checkifonestringswapcanmakestringsequal

class CheckIfOneStringSwapCanMakeStringsEqual {
    class Solution {
        fun areAlmostEqual(s1: String, s2: String): Boolean {
            if (s1 == s2) return true
            if (s1.length != s2.length) return false
            val diffIndices = mutableListOf<Int>()
            for (i in s1.indices) {
                if (s1[i] != s2[i]) {
                    diffIndices.add(i)
                }
            }
            return diffIndices.size == 2 &&
                s1[diffIndices[0]] == s2[diffIndices[1]] &&
                s1[diffIndices[1]] == s2[diffIndices[0]]
        }
    }
}

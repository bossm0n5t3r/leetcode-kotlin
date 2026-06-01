package me.bossm0n5t3r.leetcode.isSubsequence

class IsSubsequence {
    class Solution {
        fun isSubsequence(s: String, t: String): Boolean {
            val sLength = s.length
            val tLength = t.length

            if (sLength > tLength) return false

            var sIdx = 0
            var tIdx = 0
            while (sIdx < sLength) {
                if (tIdx == tLength) return false
                if (s[sIdx] == t[tIdx]) {
                    sIdx++
                    tIdx++
                } else {
                    tIdx++
                }
            }
            return true
        }
    }
}

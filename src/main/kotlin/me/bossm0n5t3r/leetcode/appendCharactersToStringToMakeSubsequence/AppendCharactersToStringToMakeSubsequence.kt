package me.bossm0n5t3r.leetcode.appendCharactersToStringToMakeSubsequence

class AppendCharactersToStringToMakeSubsequence {
    class Solution {
        fun appendCharacters(s: String, t: String): Int {
            var commonSubStringLength = 0
            var tIndex = 0
            for (i in s.indices) {
                if (tIndex >= t.length) break
                if (s[i] == t[tIndex]) {
                    commonSubStringLength++
                    tIndex++
                }
            }
            return (t.length - commonSubStringLength).coerceAtLeast(0)
        }
    }
}

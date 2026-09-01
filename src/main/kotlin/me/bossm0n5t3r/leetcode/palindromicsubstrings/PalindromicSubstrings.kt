package me.bossm0n5t3r.leetcode.palindromicsubstrings

class PalindromicSubstrings {
    class Solution {
        fun countSubstrings(s: String): Int {
            var result = 0
            for (center in s.indices) {
                result += expand(s, center, center)
                result += expand(s, center, center + 1)
            }
            return result
        }

        private fun expand(s: String, left: Int, right: Int): Int {
            if (left < 0 || right >= s.length) return 0
            if (s[left] != s[right]) return 0
            return 1 + expand(s, left - 1, right + 1)
        }
    }
}

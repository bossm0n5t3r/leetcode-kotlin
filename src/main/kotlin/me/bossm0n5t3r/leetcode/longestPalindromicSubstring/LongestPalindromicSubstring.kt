package me.bossm0n5t3r.leetcode.longestPalindromicSubstring

class LongestPalindromicSubstring {
    class Solution {
        fun longestPalindrome(s: String): String {
            if (s.length <= 1) return s
            var result = ""
            s.indices.forEach { i ->
                if (s[i].toString().length > result.length) {
                    result = s[i].toString()
                }
                if (i + 1 < s.length && s[i] == s[i + 1]) {
                    val (start, end) = extendPalindrome(s, i, i + 1)
                    if (end - start + 1 > result.length) {
                        result = s.substring(start, end + 1)
                    }
                }
                if (i >= 1 && i + 1 < s.length && s[i - 1] == s[i + 1]) {
                    val (start, end) = extendPalindrome(s, i - 1, i + 1)
                    if (end - start + 1 > result.length) {
                        result = s.substring(start, end + 1)
                    }
                }
            }
            return result
        }

        private fun extendPalindrome(s: String, start: Int, end: Int): Pair<Int, Int> {
            var copyStart = start
            var copyEnd = end
            while (copyStart >= 1 && copyEnd + 1 < s.length && s[copyStart - 1] == s[copyEnd + 1]) {
                copyStart--
                copyEnd++
            }
            return copyStart to copyEnd
        }
    }
}

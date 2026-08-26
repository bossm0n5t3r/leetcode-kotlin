package me.bossm0n5t3r.leetcode.shortestandlexicographicallysmallestbeautifulstring

class ShortestAndLexicographicallySmallestBeautifulString {
    class Solution {
        fun shortestBeautifulSubstring(s: String, k: Int): String {
            var left = 0
            var countOneBits = 0
            var result = ""

            for (right in s.indices) {
                if (s[right] == '1') {
                    countOneBits++
                }

                while (countOneBits > k) {
                    if (s[left] == '1') {
                        countOneBits--
                    }
                    left++
                }

                if (countOneBits == k) {
                    while (left < right && s[left] == '0') {
                        left++
                    }

                    val candidate = s.substring(left, right + 1)

                    if (
                        result.isEmpty() ||
                            candidate.length < result.length ||
                            (candidate.length == result.length && candidate < result)
                    ) {
                        result = candidate
                    }
                }
            }

            return result
        }
    }
}

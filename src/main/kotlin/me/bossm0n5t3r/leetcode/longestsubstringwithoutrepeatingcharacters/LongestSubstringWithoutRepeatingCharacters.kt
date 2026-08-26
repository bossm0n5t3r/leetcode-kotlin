package me.bossm0n5t3r.leetcode.longestsubstringwithoutrepeatingcharacters

class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        fun lengthOfLongestSubstring(s: String): Int {
            var left = 0
            val cache = mutableSetOf<Char>()
            var result = 0
            for (right in s.indices) {
                while (s[right] in cache) {
                    cache -= s[left]
                    left++
                }
                cache += s[right]
                result = maxOf(result, right - left + 1)
            }
            return result
        }
    }
}

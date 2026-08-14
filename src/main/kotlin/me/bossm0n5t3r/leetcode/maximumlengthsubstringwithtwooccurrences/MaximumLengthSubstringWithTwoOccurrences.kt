package me.bossm0n5t3r.leetcode.maximumlengthsubstringwithtwooccurrences

class MaximumLengthSubstringWithTwoOccurrences {
    class Solution {
        fun maximumLengthSubstring(s: String): Int {
            var result = 0
            var start = 0
            val frequency = IntArray(26) { 0 }

            for (end in s.indices) {
                val endElement = s[end]
                frequency[endElement - 'a']++

                while (frequency[endElement - 'a'] > 2) {
                    frequency[s[start] - 'a']--
                    start++
                }

                result = maxOf(result, end - start + 1)
            }

            return result
        }
    }
}

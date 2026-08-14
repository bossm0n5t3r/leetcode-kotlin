package me.bossm0n5t3r.leetcode.maximumlengthsubstringwithtwooccurrences

class MaximumLengthSubstringWithTwoOccurrences {
    class Solution {
        fun maximumLengthSubstring(s: String): Int {
            var result = 0
            var start = 0
            val frequency = mutableMapOf<Char, Int>().withDefault { 0 }

            for (end in s.indices) {
                val endElement = s[end]
                frequency[endElement] = frequency.getValue(endElement) + 1

                while (frequency.getValue(endElement) > 2) {
                    frequency[s[start]] = frequency.getValue(s[start]) - 1
                    start++
                }

                result = maxOf(result, end - start + 1)
            }

            return result
        }
    }
}

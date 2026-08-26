package me.bossm0n5t3r.leetcode.longestrepeatingcharacterreplacement

class LongestRepeatingCharacterReplacement {
    class Solution {
        fun characterReplacement(s: String, k: Int): Int {
            var left = 0
            var maxFreq = 0
            val frequency = IntArray(26) { 0 }
            var result = 0
            for (right in s.indices) {
                val char = s[right]
                frequency[char - 'A']++
                maxFreq = maxOf(maxFreq, frequency[char - 'A'])
                while (right - left + 1 - maxFreq > k) {
                    frequency[s[left] - 'A']--
                    left++
                }
                result = maxOf(result, right - left + 1)
            }
            return result
        }
    }
}

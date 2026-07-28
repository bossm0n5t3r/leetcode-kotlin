package me.bossm0n5t3r.leetcode.smallestpalindromicrearrangementi

class SmallestPalindromicRearrangementI {
    class Solution {
        fun smallestPalindrome(s: String): String {
            val frequency = IntArray(26)
            for (char in s) {
                frequency[char - 'a']++
            }

            val result = StringBuilder(s.length)
            var middle = -1

            for (i in frequency.indices) {
                repeat(frequency[i] / 2) { result.append('a' + i) }

                if (frequency[i] % 2 != 0) {
                    middle = i
                }
            }

            val halfLength = result.length
            if (middle >= 0) {
                result.append('a' + middle)
            }
            for (i in halfLength - 1 downTo 0) {
                result.append(result[i])
            }

            return result.toString()
        }
    }
}

package me.bossm0n5t3r.leetcode.maximumNumberOfVowelsInASubstringOfGivenLength

class MaximumNumberOfVowelsInASubstringOfGivenLength {
    class Solution {
        fun maxVowels(s: String, k: Int): Int {
            val vowels = setOf('a', 'e', 'i', 'o', 'u')
            var tmp = 0
            for (i in 0 until k) {
                if (vowels.contains(s[i])) {
                    tmp++
                }
            }
            var maxVowels = tmp
            for (i in k until s.length) {
                tmp += if (vowels.contains(s[i])) 1 else 0
                tmp -= if (vowels.contains(s[i - k])) 1 else 0
                if (tmp > maxVowels) maxVowels = tmp
            }
            return maxVowels
        }
    }
}

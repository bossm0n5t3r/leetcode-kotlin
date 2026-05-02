package me.bossm0n5t3r.leetcode.greatestEnglishLetterInUpperAndLowerCase

class GreatestEnglishLetterInUpperAndLowerCase {
    class Solution {
        fun greatestLetter(s: String): String {
            val lowerCaseArray = BooleanArray(26)
            val upperCaseArray = BooleanArray(26)
            for (c in s) {
                when (c) {
                    in 'A'..'Z' -> {
                        upperCaseArray[c - 'A'] = true
                    }

                    in 'a'..'z' -> {
                        lowerCaseArray[c - 'a'] = true
                    }
                }
            }
            var index = upperCaseArray.lastIndex
            while (index >= 0) {
                if (upperCaseArray[index] && lowerCaseArray[index]) return ('A' + index).toString()
                index--
            }
            return ""
        }
    }
}

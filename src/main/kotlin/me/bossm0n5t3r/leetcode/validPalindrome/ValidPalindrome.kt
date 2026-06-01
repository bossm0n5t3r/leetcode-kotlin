package me.bossm0n5t3r.leetcode.validPalindrome

class ValidPalindrome {
    class Solution {
        fun isPalindrome(s: String): Boolean =
            s.mapNotNull {
                    when {
                        it.isLetter() -> it.lowercase()
                        it.isDigit() -> it
                        else -> null
                    }
                }
                .let { it == it.reversed() }
    }
}

package me.bossm0n5t3r.leetcode.validpalindrome

class ValidPalindrome {
    class Solution {
        fun isPalindrome(s: String): Boolean {
            return s.filter { it.isLetterOrDigit() }.lowercase().let { it == it.reversed() }
        }
    }
}

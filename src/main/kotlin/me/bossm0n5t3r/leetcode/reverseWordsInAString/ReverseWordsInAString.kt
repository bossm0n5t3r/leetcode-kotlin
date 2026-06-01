package me.bossm0n5t3r.leetcode.reverseWordsInAString

class ReverseWordsInAString {
    class Solution {
        fun reverseWords(s: String): String =
            s.split(" ").filterNot { it.isBlank() }.reversed().joinToString(" ")
    }
}

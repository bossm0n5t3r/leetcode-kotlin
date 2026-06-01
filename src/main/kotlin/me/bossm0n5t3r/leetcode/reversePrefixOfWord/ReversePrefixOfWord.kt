package me.bossm0n5t3r.leetcode.reversePrefixOfWord

class ReversePrefixOfWord {
    class Solution {
        fun reversePrefix(word: String, ch: Char): String {
            val firstIndex = word.indexOf(ch).takeIf { it != -1 } ?: return word
            return word.substring(0, firstIndex + 1).reversed() + word.substring(firstIndex + 1)
        }
    }
}

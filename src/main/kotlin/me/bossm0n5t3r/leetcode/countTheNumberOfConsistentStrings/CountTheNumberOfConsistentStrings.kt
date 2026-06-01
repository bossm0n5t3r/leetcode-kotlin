package me.bossm0n5t3r.leetcode.countTheNumberOfConsistentStrings

class CountTheNumberOfConsistentStrings {
    class Solution {
        fun countConsistentStrings(allowed: String, words: Array<String>): Int {
            val allowedCharSet = allowed.toSet()
            return words.count { allowedCharSet.containsAll(it.toSet()) }
        }
    }
}

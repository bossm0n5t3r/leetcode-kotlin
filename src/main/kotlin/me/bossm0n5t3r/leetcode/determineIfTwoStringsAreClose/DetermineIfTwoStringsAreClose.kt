package me.bossm0n5t3r.leetcode.determineIfTwoStringsAreClose

class DetermineIfTwoStringsAreClose {
    class Solution {
        fun closeStrings(word1: String, word2: String): Boolean {
            val word1Map = word1.groupingBy { it }.eachCount()
            val word2Map = word2.groupingBy { it }.eachCount()

            return (word1Map.keys == word2Map.keys &&
                word1Map.values.sorted() == word2Map.values.sorted())
        }
    }
}

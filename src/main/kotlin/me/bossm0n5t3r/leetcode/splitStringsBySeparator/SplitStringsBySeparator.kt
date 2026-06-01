package me.bossm0n5t3r.leetcode.splitStringsBySeparator

class SplitStringsBySeparator {
    class Solution {
        fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> =
            words.flatMap { word -> word.split(separator) }.filter { it.isNotBlank() }
    }
}

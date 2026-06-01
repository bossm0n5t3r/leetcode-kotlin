package me.bossm0n5t3r.leetcode.replaceWords

class ReplaceWords {
    class Solution {
        fun replaceWords(dictionary: List<String>, sentence: String): String {
            val sortedDictionary = dictionary.sorted()
            return sentence
                .split(" ")
                .map {
                    for (root in sortedDictionary) {
                        if (it.startsWith(root)) return@map root
                    }
                    it
                }
                .joinToString(" ")
        }
    }
}

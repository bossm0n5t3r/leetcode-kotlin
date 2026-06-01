package me.bossm0n5t3r.leetcode.findCommonCharacters

class FindCommonCharacters {
    class Solution {
        fun commonChars(words: Array<String>): List<String> {
            val charToCountForEachWord = words.map { word -> word.groupingBy { it }.eachCount() }
            val commonCharSet =
                charToCountForEachWord.map { it.keys }.reduce { acc, chars -> acc.intersect(chars) }
            val result = mutableListOf<String>()
            for (char in commonCharSet) {
                var commonSize = Int.MAX_VALUE
                for (charToEachCount in charToCountForEachWord) {
                    commonSize = minOf(commonSize, charToEachCount[char] ?: Int.MAX_VALUE)
                }
                repeat(commonSize) { result.add(char.toString()) }
            }
            return result
        }
    }
}

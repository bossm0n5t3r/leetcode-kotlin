package me.bossm0n5t3r.leetcode.countvowelstringsinranges

class CountVowelStringsInRanges {
    class Solution {
        fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
            val vowelLetters = setOf('a', 'e', 'i', 'o', 'u')
            return words
                .map { it.first() in vowelLetters && it.last() in vowelLetters }
                .let { it.runningFold(0) { acc: Int, b: Boolean -> acc + if (b) 1 else 0 } }
                .let { prefixSum ->
                    queries
                        .map {
                            val (l, r) = it
                            prefixSum[r + 1] - prefixSum[l]
                        }
                        .toIntArray()
                }
        }
    }
}

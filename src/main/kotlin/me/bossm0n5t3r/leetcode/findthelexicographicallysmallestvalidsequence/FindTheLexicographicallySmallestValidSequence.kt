package me.bossm0n5t3r.leetcode.findthelexicographicallysmallestvalidsequence

class FindTheLexicographicallySmallestValidSequence {
    class Solution {
        fun validSequence(word1: String, word2: String): IntArray {
            val last = IntArray(word2.length) { -1 }
            var word1Index = word1.lastIndex
            for (i in word2.lastIndex downTo 0) {
                while (word1Index >= 0 && word1[word1Index] != word2[i]) {
                    word1Index--
                }
                last[i] = word1Index
                word1Index--
            }
            val result = IntArray(word2.length)
            var word2Index = 0
            var used = false
            for (i in word1.indices) {
                if (word2Index == word2.length) break
                val cur = word1[i]
                if (cur == word2[word2Index]) {
                    result[word2Index++] = i
                    continue
                }
                if (!used && (word2Index == word2.lastIndex || i < last[word2Index + 1])) {
                    used = true
                    result[word2Index++] = i
                }
            }
            return if (word2Index == word2.length) result else intArrayOf()
        }
    }
}

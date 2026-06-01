package me.bossm0n5t3r.leetcode.editDistance

class EditDistance {
    class Solution {
        fun minDistance(word1: String, word2: String): Int {
            if (word1.isEmpty()) return word2.length
            if (word2.isEmpty()) return word1.length

            val dp = Array(word1.length + 1) { IntArray(word2.length + 1) { -1 } }
            return topDown(dp, word1, word2, 0, 0)
        }

        private fun topDown(
            dp: Array<IntArray>,
            word1: String,
            word2: String,
            word1Index: Int,
            word2Index: Int,
        ): Int {
            if (word1.length <= word1Index) return word2.length - word2Index
            if (word2.length <= word2Index) return word1.length - word1Index

            if (dp[word1Index][word2Index] != -1) return dp[word1Index][word2Index]

            dp[word1Index][word2Index] =
                if (word1[word1Index] == word2[word2Index]) {
                    topDown(dp, word1, word2, word1Index + 1, word2Index + 1)
                } else {
                    val inserted = 1 + topDown(dp, word1, word2, word1Index, word2Index + 1)
                    val deleted = 1 + topDown(dp, word1, word2, word1Index + 1, word2Index)
                    val replaced = 1 + topDown(dp, word1, word2, word1Index + 1, word2Index + 1)
                    minOf(inserted, deleted, replaced)
                }
            return dp[word1Index][word2Index]
        }
    }
}

package me.bossm0n5t3r.leetcode.deleteOperationForTwoStrings

import kotlin.math.max

class DeleteOperationForTwoStrings {
    class Solution {
        fun minDistance(word1: String, word2: String): Int {
            val dp = Array(word1.length + 1) { IntArray(word2.length + 1) { 0 } }
            (1..word1.length).forEach { r ->
                (1..word2.length).forEach { c ->
                    dp[r][c] =
                        if (word1[r - 1] == word2[c - 1]) {
                            dp[r - 1][c - 1] + 1
                        } else {
                            max(dp[r - 1][c], dp[r][c - 1])
                        }
                }
            }
            return word1.length + word2.length - dp[word1.length][word2.length] * 2
        }
    }
}

package me.bossm0n5t3r.leetcode.wordBreak

class WordBreak {
    class Solution {
        fun wordBreak(s: String, wordDict: List<String>): Boolean {
            val dp = BooleanArray(s.length) { false }
            for (i in s.indices) {
                wordDict.forEach { word ->
                    if (i + 1 >= word.length) {
                        if (
                            word == s.substring(i - word.length + 1, i + 1) &&
                                (i + 1 == word.length || dp[i - word.length])
                        ) {
                            dp[i] = true
                        }
                    }
                }
            }
            return dp[s.length - 1]
        }
    }
}

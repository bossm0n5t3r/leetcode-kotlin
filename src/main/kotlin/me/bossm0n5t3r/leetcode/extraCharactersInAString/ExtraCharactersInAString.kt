package me.bossm0n5t3r.leetcode.extraCharactersInAString

class ExtraCharactersInAString {
    class Solution {
        fun minExtraChar(s: String, dictionary: Array<String>): Int {
            val set = dictionary.toSet()
            val dp = IntArray(s.length + 1) { s.length + 1 }
            dp[0] = 0
            for (i in 1..s.length) {
                dp[i] = dp[i - 1] + 1
                for (j in 1..i) {
                    if (set.contains(s.substring(i - j, i))) {
                        if (dp[i - j] < dp[i]) {
                            dp[i] = dp[i - j]
                        }
                    }
                }
            }
            return dp[s.length]
        }
    }
}

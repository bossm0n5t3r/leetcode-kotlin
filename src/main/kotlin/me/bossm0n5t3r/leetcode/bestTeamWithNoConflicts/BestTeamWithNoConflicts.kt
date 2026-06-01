package me.bossm0n5t3r.leetcode.bestTeamWithNoConflicts

import java.util.Arrays

class BestTeamWithNoConflicts {
    class Solution {
        fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
            val n = ages.size
            val candidate = Array(n) { IntArray(2) }
            for (i in 0 until n) {
                candidate[i][0] = ages[i]
                candidate[i][1] = scores[i]
            }
            Arrays.sort(candidate) { a, b -> if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0] }
            val dp = IntArray(n) { 0 }
            dp[0] = candidate[0][1]
            var max = dp[0]
            for (i in 1 until n) {
                dp[i] = candidate[i][1]
                for (j in 0 until i) {
                    if (candidate[j][1] <= candidate[i][1]) {
                        dp[i] = dp[i].coerceAtLeast(candidate[i][1] + dp[j])
                    }
                }
                max = dp[i].coerceAtLeast(max)
            }
            return max
        }
    }
}

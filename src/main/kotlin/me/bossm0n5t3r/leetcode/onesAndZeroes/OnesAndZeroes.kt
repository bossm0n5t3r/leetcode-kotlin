package me.bossm0n5t3r.leetcode.onesAndZeroes

import kotlin.math.max

class OnesAndZeroes {
    class Solution {
        fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
            val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
            strs.forEach { str ->
                val zero = str.count { it == '0' }
                val one = str.length - zero
                (m downTo zero step 1).forEach { i ->
                    (n downTo one step 1).forEach { j ->
                        dp[i][j] = max(dp[i][j], dp[i - zero][j - one] + 1)
                    }
                }
            }
            return dp[m][n]
        }
    }
}

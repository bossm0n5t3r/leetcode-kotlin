package me.bossm0n5t3r.leetcode.sumgame

class SumGame {
    class Solution {
        fun sumGame(num: String): Boolean {
            val half = num.length / 2
            var sumDiff = 0
            var questionDiff = 0

            for (i in num.indices) {
                val ch = num[i]
                if (ch == '?') {
                    questionDiff += if (i < half) 1 else -1
                } else {
                    val digit = ch - '0'
                    sumDiff += if (i < half) digit else -digit
                }
            }

            return 2 * sumDiff + 9 * questionDiff != 0
        }
    }
}

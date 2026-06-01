package me.bossm0n5t3r.leetcode.maximumscoreaftersplittingastring

class MaximumScoreAfterSplittingAString {
    class Solution {
        fun maxScore(s: String): Int {
            val initialZeros = if (s.first() == '0') 1 else 0
            val initialOnes = s.substring(1).count { it == '1' }
            val initial = Triple(initialZeros + initialOnes, initialZeros, initialOnes)
            return s.foldIndexed(initial) { index: Int, acc: Triple<Int, Int, Int>, c: Char ->
                    if (index == 0 || index == s.lastIndex) return@foldIndexed acc
                    val (score, zeros, ones) = acc
                    when (c) {
                        '0' -> Triple(maxOf(score, zeros + 1 + ones), zeros + 1, ones)
                        else -> Triple(maxOf(score, zeros + ones - 1), zeros, ones - 1)
                    }
                }
                .first
        }
    }
}

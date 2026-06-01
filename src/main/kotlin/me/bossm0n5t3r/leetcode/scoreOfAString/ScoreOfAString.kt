package me.bossm0n5t3r.leetcode.scoreOfAString

import kotlin.math.abs

class ScoreOfAString {
    class Solution {
        fun scoreOfString(s: String): Int =
            s.windowed(2).sumOf { abs(it.first().code - it.last().code) }
    }
}

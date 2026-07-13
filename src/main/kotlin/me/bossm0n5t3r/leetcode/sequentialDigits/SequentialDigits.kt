package me.bossm0n5t3r.leetcode.sequentialDigits

class SequentialDigits {
    class Solution {
        fun sequentialDigits(low: Int, high: Int): List<Int> =
            (low.toString().length..high.toString().length).flatMap { n ->
                generateSequentialDigits(n, low, high)
            }

        private fun generateSequentialDigits(n: Int, low: Int, high: Int): List<Int> =
            (1..9).windowed(n).map { it.joinToString("").toInt() }.filter { it in low..high }
    }
}

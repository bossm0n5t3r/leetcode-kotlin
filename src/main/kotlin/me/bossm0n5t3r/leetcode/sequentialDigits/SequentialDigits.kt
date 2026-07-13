package me.bossm0n5t3r.leetcode.sequentialDigits

class SequentialDigits {
    class Solution {
        fun sequentialDigits(low: Int, high: Int): List<Int> {
            val result = mutableListOf<Int>()
            val minLen = low.toString().length
            val maxLen = high.toString().length

            for (length in minLen..maxLen) {
                for (start in 1..(10 - length)) {
                    var num = 0
                    for (digit in start until start + length) {
                        num = num * 10 + digit
                    }
                    if (num in low..high) {
                        result.add(num)
                    }
                }
            }
            return result
        }
    }
}

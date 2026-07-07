package me.bossm0n5t3r.leetcode.concatenatenonzerodigitsandmultiplybysumi

class ConcatenateNonZeroDigitsAndMultiplyBySumI {
    class Solution {
        fun sumAndMultiply(n: Int): Long {
            return n.toString()
                .fold("" to 0L) { (x, sum), c ->
                    val digit = c.digitToInt()
                    if (digit == 0) return@fold x to sum
                    x + c to sum + digit
                }
                .let { (x, sum) -> (x.toLongOrNull() ?: 0) * sum }
        }
    }
}

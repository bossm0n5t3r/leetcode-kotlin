package me.bossm0n5t3r.leetcode.bitwiseAndOfNumbersRange

class BitwiseAndOfNumbersRange {
    class Solution {
        fun rangeBitwiseAnd(left: Int, right: Int): Int {
            val start = left.toString(2).padStart(32, '0')
            val end = right.toString(2).padStart(32, '0')
            for (i in 0 until 32) {
                if (start[i] != end[i]) {
                    return start.substring(0, i + 1).padEnd(32, '0').toInt(2)
                }
            }
            return left
        }
    }
}

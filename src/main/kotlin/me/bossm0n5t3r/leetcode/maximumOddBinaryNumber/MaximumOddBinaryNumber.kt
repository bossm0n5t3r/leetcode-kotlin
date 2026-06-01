package me.bossm0n5t3r.leetcode.maximumOddBinaryNumber

class MaximumOddBinaryNumber {
    class Solution {
        fun maximumOddBinaryNumber(s: String): String {
            val countOne = s.count { it == '1' } - 1
            return (List(countOne) { 1 } + List(s.length - countOne - 1) { 0 } + listOf(1))
                .joinToString("")
        }
    }
}

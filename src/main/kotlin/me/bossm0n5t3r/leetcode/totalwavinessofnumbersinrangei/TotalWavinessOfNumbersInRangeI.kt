package me.bossm0n5t3r.leetcode.totalwavinessofnumbersinrangei

class TotalWavinessOfNumbersInRangeI {
    class Solution {
        fun totalWaviness(num1: Int, num2: Int): Int {
            return (num1..num2).sumOf { it.getWaviness() }
        }

        private fun Int.getWaviness(): Int {
            return this.toString()
                .map { it.digitToInt() }
                .windowed(2)
                .map { it.first() - it.last() }
                .windowed(size = 2)
                .count { it.size == 2 && (it.first() * it.last()) < 0 }
        }
    }
}

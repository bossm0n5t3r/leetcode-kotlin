package me.bossm0n5t3r.leetcode.totalwavinessofnumbersinrangei

class TotalWavinessOfNumbersInRangeI {
    class Solution {
        fun totalWaviness(num1: Int, num2: Int): Int {
            return (num1..num2).sumOf { it.getWaviness() }
        }

        private fun Int.getWaviness(): Int {
            var number = this
            val previousDigit = number % 10
            number /= 10

            var currentDigit = number % 10
            var previousDiff = currentDigit - previousDigit
            number /= 10

            var waviness = 0
            while (number > 0) {
                val nextDigit = number % 10
                val currentDiff = nextDigit - currentDigit

                if (previousDiff * currentDiff < 0) waviness++

                previousDiff = currentDiff
                currentDigit = nextDigit
                number /= 10
            }
            return waviness
        }
    }
}

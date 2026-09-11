package me.bossm0n5t3r.leetcode.unique3digitevennumbers

class Unique3DigitEvenNumbers {
    class Solution {
        fun totalNumbers(digits: IntArray): Int {
            val frequency = IntArray(10)
            for (digit in digits) frequency[digit]++
            var result = 0
            for (number in 100..998 step 2) {
                val hundreds = number / 100
                val tens = (number / 10) % 10
                val ones = number % 10
                val required = IntArray(10)
                required[hundreds]++
                required[tens]++
                required[ones]++
                var canMake = true
                for (digit in 0..9) {
                    if (required[digit] > frequency[digit]) {
                        canMake = false
                        break
                    }
                }
                if (canMake) result++
            }
            return result
        }
    }
}

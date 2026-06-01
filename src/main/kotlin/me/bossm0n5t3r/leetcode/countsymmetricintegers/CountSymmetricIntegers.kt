package me.bossm0n5t3r.leetcode.countsymmetricintegers

class CountSymmetricIntegers {
    class Solution {
        fun countSymmetricIntegers(low: Int, high: Int): Int {
            return (low..high).count {
                val numberString = it.toString()
                if (numberString.length % 2 != 0) return@count false
                var firstHalf = 0
                var secondHalf = 0
                for ((index, digit) in numberString.withIndex()) {
                    if (index < numberString.length / 2) {
                        firstHalf += digit.digitToInt()
                    } else {
                        secondHalf += digit.digitToInt()
                    }
                }
                firstHalf == secondHalf
            }
        }
    }
}

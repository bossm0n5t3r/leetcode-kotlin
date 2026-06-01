package me.bossm0n5t3r.leetcode.sumOfDigitsOfStringAfterConvert

class SumOfDigitsOfStringAfterConvert {
    class Solution {
        fun getLucky(s: String, k: Int): Int = s.convert().transform(k).toInt()

        private fun String.convert(): String = this.map { (it - 'a') + 1 }.joinToString("")

        private fun String.transform(k: Int): String {
            if (k == 0) return this
            return this.sumOf { it - '0' }.toString().transform(k - 1)
        }
    }
}

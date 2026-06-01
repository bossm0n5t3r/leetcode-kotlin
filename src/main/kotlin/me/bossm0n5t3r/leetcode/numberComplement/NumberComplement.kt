package me.bossm0n5t3r.leetcode.numberComplement

class NumberComplement {
    class Solution {
        fun findComplement(num: Int): Int = num.toString(2).complement().toInt(2)

        private fun String.complement(): String =
            this.map { '0' + ('1' - it) }.toCharArray().concatToString()
    }
}

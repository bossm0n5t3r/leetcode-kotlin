package me.bossm0n5t3r.leetcode.checkdivisibilitybydigitsumandproduct

class CheckDivisibilityByDigitSumAndProduct {
    class Solution {
        fun checkDivisibility(n: Int): Boolean {
            val (sum, product) =
                n.toString().fold(0 to 1) { acc, ch ->
                    val (curSum, curProduct) = acc
                    val number = ch.digitToInt()
                    curSum + number to curProduct * number
                }
            return n % (sum + product) == 0
        }
    }
}

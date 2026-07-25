package me.bossm0n5t3r.leetcode.maximumproductoftwodigits

class MaximumProductOfTwoDigits {
    class Solution {
        fun maxProduct(n: Int): Int {
            return n.toString()
                .map { it.digitToInt() }
                .sortedDescending()
                .take(2)
                .let { it.first() * it.last() }
        }
    }
}

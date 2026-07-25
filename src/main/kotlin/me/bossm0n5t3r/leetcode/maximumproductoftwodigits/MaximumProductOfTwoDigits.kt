package me.bossm0n5t3r.leetcode.maximumproductoftwodigits

class MaximumProductOfTwoDigits {
    class Solution {
        fun maxProduct(n: Int): Int {
            var first = 0
            var second = 0
            var tmp = n
            while (tmp > 0) {
                val x = tmp % 10
                when {
                    x > first -> {
                        second = first
                        first = x
                    }
                    x > second -> {
                        second = x
                    }
                }
                tmp /= 10
            }
            return first * second
        }
    }
}

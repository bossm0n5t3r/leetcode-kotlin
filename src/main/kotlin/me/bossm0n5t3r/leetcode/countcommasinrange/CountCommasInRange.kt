package me.bossm0n5t3r.leetcode.countcommasinrange

class CountCommasInRange {
    class Solution {
        fun countCommas(n: Int): Int {
            if (n < 1000) return 0
            val thousands = ArrayDeque<Int>()
            var tmp = n
            while (tmp > 0) {
                thousands.addFirst(tmp % 1000)
                tmp /= 1000
            }
            var result = thousands.removeLastOrNull()?.let { it + 1 } ?: return 0
            var times = 1000
            for (i in thousands.lastIndex downTo 0) {
                result += (thousands[i] - 1) * times
                times += 1000
            }
            return result
        }
    }
}

package me.bossm0n5t3r.leetcode.countgoodnumbers

class CountGoodNumbers {
    class Solution {
        fun countGoodNumbers(n: Long): Int {
            val modulo = 1_000_000_007L
            return ((quickMul(5, (n + 1) / 2, modulo) * quickMul(4, n / 2, modulo)) % modulo)
                .toInt()
        }

        // use fast exponentiation to calculate x^y % mod
        private fun quickMul(x: Int, y: Long, mod: Long): Long {
            var tmpY = y
            var ret: Long = 1
            var mul = x.toLong()
            while (tmpY > 0) {
                if (tmpY % 2 == 1L) {
                    ret = (ret * mul) % mod
                }
                mul = (mul * mul) % mod
                tmpY /= 2
            }
            return ret
        }
    }
}

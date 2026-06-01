package me.bossm0n5t3r.leetcode.rotateddigits

class RotatedDigits {
    class Solution {
        fun rotatedDigits(n: Int): Int = (1..n).count { it.isGood() }

        private fun Int.isGood(): Boolean {
            val numberString = this.toString()
            var rotated = 0
            for (c in numberString) {
                val digit = c.digitToInt()
                val rotatedDigit = ROTATED_DIGITS[digit] ?: return false
                rotated = rotated * 10 + rotatedDigit
            }
            return rotated != this
        }

        companion object {
            private val ROTATED_DIGITS =
                mapOf(0 to 0, 1 to 1, 8 to 8, 2 to 5, 5 to 2, 6 to 9, 9 to 6)
        }
    }
}

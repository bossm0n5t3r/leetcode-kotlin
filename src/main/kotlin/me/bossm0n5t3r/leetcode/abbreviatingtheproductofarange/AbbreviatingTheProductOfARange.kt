package me.bossm0n5t3r.leetcode.abbreviatingtheproductofarange

import java.math.BigInteger

class AbbreviatingTheProductOfARange {
    class Solution {
        fun abbreviateProduct(left: Int, right: Int): String {
            var number = BigInteger.ONE
            for (i in left..right) {
                number = number.times(i.toBigInteger())
            }
            val (numberWithoutTrailingZeros, trailingZerosCount) =
                number.toString().splitWithTailingZeros()
            return numberWithoutTrailingZeros.summarized() + trailingZerosCount.denoted()
        }

        private fun String.splitWithTailingZeros(): Pair<String, Int> {
            var count = 0
            var result = this
            while (result.lastOrNull() == '0') {
                result = result.dropLast(1)
                count++
            }
            return result to count
        }

        private fun String.summarized(): String =
            if (this.length > 10) {
                this.take(5) + "..." + this.takeLast(5)
            } else {
                this
            }

        private fun Int.denoted(): String = "e$this"
    }
}

package me.bossm0n5t3r.leetcode.kthsmallestinlexicographicalorder

class KThSmallestInLexicographicalOrder {
    class Solution {
        fun findKthNumber(n: Int, k: Int): Int {
            var cur = 1L
            var countK = (k - 1).toLong()
            while (countK > 0) {
                val steps = calculateSteps(n, cur, cur + 1)
                if (steps <= countK) {
                    cur++
                    countK -= steps
                } else {
                    cur *= 10
                    countK--
                }
            }
            return cur.toInt()
        }

        private fun calculateSteps(n: Int, prefix1: Long, prefix2: Long): Int {
            var steps = 0
            var tmpPrefix1 = prefix1
            var tmpPrefix2 = prefix2
            while (tmpPrefix1 <= n) {
                steps += (minOf((n + 1).toLong(), tmpPrefix2) - tmpPrefix1).toInt()
                tmpPrefix1 *= 10
                tmpPrefix2 *= 10
            }
            return steps
        }
    }
}

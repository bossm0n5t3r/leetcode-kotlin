package me.bossm0n5t3r.leetcode.xofakindinadeckofcards

class XOfAKindInADeckOfCards {
    class Solution {
        fun hasGroupsSizeX(deck: IntArray): Boolean =
            deck.toList().groupingBy { it }.eachCount().values.reduce { acc, i -> gcd(acc, i) } > 1

        private fun gcd(x: Int, y: Int): Int {
            if (y > 0) return gcd(y, x % y)
            return x
        }
    }
}

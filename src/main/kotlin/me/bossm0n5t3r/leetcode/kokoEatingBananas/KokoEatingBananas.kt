package me.bossm0n5t3r.leetcode.kokoEatingBananas

class KokoEatingBananas {
    class Solution {
        fun minEatingSpeed(piles: IntArray, h: Int): Int {
            val maxPile = binarySearchForFindingMax(piles, 0, piles.size - 1)
            if (piles.size == h) return maxPile
            var start = 0
            var end = maxPile
            while (start < end) {
                println("start: $start, end: $end")
                val mid = (start + end) / 2
                if (mid == 0) break
                if (isValid(piles, h, mid)) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }
            return if (start == 0) 1 else start
        }

        @Suppress("ReturnCount")
        private fun binarySearchForFindingMax(piles: IntArray, start: Int, end: Int): Int {
            if (start > end) return -1
            if (start == end) return piles[start]
            if (start + 1 == end) return maxOf(piles[start], piles[end])
            val mid = (start + end) / 2

            return maxOf(
                binarySearchForFindingMax(piles, start, mid),
                binarySearchForFindingMax(piles, mid + 1, end),
            )
        }

        private fun isValid(piles: IntArray, h: Int, k: Int): Boolean {
            var hours = 0L
            for (pile in piles) {
                hours += pile / k
                if (pile % k != 0) hours++
            }
            return hours <= h
        }
    }
}

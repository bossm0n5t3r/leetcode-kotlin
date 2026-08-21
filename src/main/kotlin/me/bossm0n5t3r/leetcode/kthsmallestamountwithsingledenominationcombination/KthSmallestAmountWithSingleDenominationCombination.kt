package me.bossm0n5t3r.leetcode.kthsmallestamountwithsingledenominationcombination

class KthSmallestAmountWithSingleDenominationCombination {
    class Solution {
        fun findKthSmallest(coins: IntArray, k: Int): Long {
            var left = 1L
            var right = coins.min().toLong() * k

            while (left < right) {
                val middle = left + (right - left) / 2
                if (countAmountsAtMost(coins, middle) >= k) {
                    right = middle
                } else {
                    left = middle + 1
                }
            }

            return left
        }

        private fun countAmountsAtMost(coins: IntArray, limit: Long): Long {
            var count = 0L

            for (mask in 1 until (1 shl coins.size)) {
                var lcm = 1L
                var selectedCount = 0

                for (index in coins.indices) {
                    if (mask and (1 shl index) == 0) continue

                    selectedCount++
                    lcm = lcmAtMost(lcm, coins[index].toLong(), limit)
                    if (lcm > limit) break
                }

                if (lcm <= limit) {
                    val multiples = limit / lcm
                    count += if (selectedCount % 2 == 1) multiples else -multiples
                }
            }

            return count
        }

        private fun lcmAtMost(a: Long, b: Long, limit: Long): Long {
            val divided = a / gcd(a, b)
            return if (divided > limit / b) limit + 1 else divided * b
        }

        private tailrec fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
    }
}

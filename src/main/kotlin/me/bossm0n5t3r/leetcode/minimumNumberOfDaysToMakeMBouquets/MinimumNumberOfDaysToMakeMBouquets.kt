package me.bossm0n5t3r.leetcode.minimumNumberOfDaysToMakeMBouquets

class MinimumNumberOfDaysToMakeMBouquets {
    class Solution {
        fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
            if (m * k > bloomDay.size) return -1
            var left = 1
            var right = requireNotNull(bloomDay.maxOrNull())
            while (left < right) {
                val mid = left + (right - left) / 2
                if (canMake(bloomDay, m, k, mid)) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            return if (canMake(bloomDay, m, k, left)) left else -1
        }

        private fun canMake(bloomDayArray: IntArray, m: Int, k: Int, days: Int): Boolean {
            var bouquets = 0
            var flowers = 0
            for (bloomDay in bloomDayArray) {
                if (bloomDay <= days) {
                    flowers++
                    if (flowers == k) {
                        bouquets++
                        flowers = 0
                    }
                    continue
                }
                flowers = 0
            }
            return bouquets >= m
        }
    }
}

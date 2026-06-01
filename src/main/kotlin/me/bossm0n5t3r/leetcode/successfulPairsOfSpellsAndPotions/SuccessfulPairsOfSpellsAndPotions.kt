package me.bossm0n5t3r.leetcode.successfulPairsOfSpellsAndPotions

class SuccessfulPairsOfSpellsAndPotions {
    class Solution {
        fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
            val potionsSize = potions.size
            val sortedPotions = potions.sorted()
            val result = IntArray(spells.size) { 0 }
            for (i in spells.indices) {
                result[i] = potionsSize - binarySearch(sortedPotions, spells[i], success)
            }
            return result
        }

        private fun binarySearch(sortedPotions: List<Int>, spell: Int, success: Long): Int {
            val target = if (success % spell == 0L) success / spell else success / spell + 1
            var left = 0
            var right = sortedPotions.size
            while (left < right) {
                val mid = (left + right) / 2
                if (sortedPotions[mid] >= target) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
            return left
        }
    }
}

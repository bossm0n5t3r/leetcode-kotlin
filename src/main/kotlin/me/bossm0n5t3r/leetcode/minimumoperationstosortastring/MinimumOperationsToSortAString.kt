package me.bossm0n5t3r.leetcode.minimumoperationstosortastring

class MinimumOperationsToSortAString {
    class Solution {
        fun minOperations(s: String): Int {
            val n = s.length

            var isSorted = true
            var minChar = s[0]
            var maxChar = s[0]

            for (i in 1 until n) {
                if (s[i] < s[i - 1]) isSorted = false
                if (s[i] < minChar) minChar = s[i]
                if (s[i] > maxChar) maxChar = s[i]
            }

            return when {
                isSorted -> 0
                n == 2 -> -1
                s[0] == minChar || s[n - 1] == maxChar -> 1
                (1 until n - 1).any { s[it] == minChar || s[it] == maxChar } -> 2
                else -> 3
            }
        }
    }
}

package me.bossm0n5t3r.leetcode.getEqualSubstringsWithinBudget

import kotlin.math.abs

class GetEqualSubstringsWithinBudget {
    class Solution {
        fun equalSubstring(s: String, t: String, maxCost: Int): Int {
            var start = 0
            var currentCost = 0
            var result = 0
            for (end in s.indices) {
                currentCost += abs(s[end] - t[end])
                while (currentCost > maxCost) {
                    currentCost -= abs(s[start] - t[start])
                    start++
                }
                if (end - start + 1 > result) {
                    result = end - start + 1
                }
            }
            return result
        }
    }
}

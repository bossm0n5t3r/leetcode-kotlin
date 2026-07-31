package me.bossm0n5t3r.leetcode.minimumnumberofpushestotypewordii

class MinimumNumberOfPushesToTypeWordII {
    class Solution {
        fun minimumPushes(word: String): Int {
            val frequencies = IntArray(26)
            for (char in word) {
                frequencies[char - 'a']++
            }

            frequencies.sortDescending()

            var result = 0
            for (index in frequencies.indices) {
                result += frequencies[index] * (index / 8 + 1)
            }
            return result
        }
    }
}

package me.bossm0n5t3r.leetcode.maximizeactivesectionwithtradei

class MaximizeActiveSectionWithTradeI {
    class Solution {
        fun maxActiveSectionsAfterTrade(input: String): Int {
            var totalOnes = 0
            var prevZeros = 0
            var maxGain = 0

            var i = 0
            val n = input.length
            while (i < n) {
                var ones = 0
                while (i < n && input[i] == '1') {
                    i++
                    totalOnes++
                    ones++
                }

                var zeros = 0
                while (i < n && input[i] == '0') {
                    i++
                    zeros++
                }

                if (prevZeros > 0 && ones > 0 && zeros > 0) {
                    maxGain = maxOf(maxGain, prevZeros + zeros)
                }

                prevZeros = zeros
            }

            return totalOnes + maxGain
        }
    }
}

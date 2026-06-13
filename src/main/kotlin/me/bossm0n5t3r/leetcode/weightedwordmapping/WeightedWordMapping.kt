package me.bossm0n5t3r.leetcode.weightedwordmapping

class WeightedWordMapping {
    class Solution {
        fun mapWordWeights(words: Array<String>, weights: IntArray): String {
            return buildString(words.size) {
                for (word in words) {
                    append('z' - word.toWeight(weights))
                }
            }
        }

        private fun String.toWeight(weights: IntArray): Int {
            return fold(0) { acc, ch -> (acc + weights[ch - 'a']) % MOD }
        }

        private companion object {
            const val MOD = 26
        }
    }
}

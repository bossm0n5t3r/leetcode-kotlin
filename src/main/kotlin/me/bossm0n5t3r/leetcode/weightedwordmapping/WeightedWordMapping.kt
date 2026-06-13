package me.bossm0n5t3r.leetcode.weightedwordmapping

class WeightedWordMapping {
    class Solution {
        fun mapWordWeights(words: Array<String>, weights: IntArray): String {
            return words.joinToString("") { word -> word.toWeight(weights).toMappedCharacter() }
        }

        private fun String.toWeight(weights: IntArray): Int {
            return sumOf { weights[it - 'a'] } % MOD
        }

        private fun Int.toMappedCharacter(): String {
            return ('a' + (25 - this)).toString()
        }

        private companion object {
            const val MOD = 26
        }
    }
}

package me.bossm0n5t3r.leetcode.wordsubsets

class WordSubsets {
    class Solution {
        fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
            val word2CountMap =
                words2.toSet().fold(mutableMapOf<Char, Int>()) {
                    acc: MutableMap<Char, Int>,
                    s: String ->
                    acc + s.countMap()
                }
            return words1.filter { it.countMap() in word2CountMap }
        }

        private fun String.countMap(): Map<Char, Int> = this.groupingBy { it }.eachCount()

        private operator fun Map<Char, Int>.contains(other: Map<Char, Int>): Boolean {
            for ((key, value) in this) {
                val otherValue = other[key]
                if (otherValue == null || otherValue < value) {
                    return false
                }
            }
            return true
        }

        private operator fun MutableMap<Char, Int>.plus(
            other: Map<Char, Int>
        ): MutableMap<Char, Int> {
            for ((key, value) in other) {
                this[key] = maxOf(this.getOrDefault(key, 0), value)
            }
            return this
        }
    }
}

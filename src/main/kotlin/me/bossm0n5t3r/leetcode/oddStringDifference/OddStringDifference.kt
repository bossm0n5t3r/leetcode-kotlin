package me.bossm0n5t3r.leetcode.oddStringDifference

class OddStringDifference {
    class Solution {
        fun oddString(words: Array<String>): String =
            words
                .groupBy { it.toDifferenceIntegerArray() }
                .filterValues { it.size == 1 }
                .values
                .first()
                .first()

        private fun String.toDifferenceIntegerArray(): List<Int> =
            this.windowed(2).map { it[1].code - it[0].code }
    }
}

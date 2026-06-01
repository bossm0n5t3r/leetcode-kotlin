package me.bossm0n5t3r.leetcode.minimumtimedifference

class MinimumTimeDifference {
    class Solution {
        fun findMinDifference(timePoints: List<String>): Int {
            val sortedTimePoints =
                timePoints
                    .map { it.toHHMM() }
                    .sortedWith(
                        compareBy<Pair<Int, Int>> { it.first }.then(compareBy { it.second })
                    )
            val additionalTimePoints = sortedTimePoints.first() + "24:00".toHHMM()
            return (sortedTimePoints + additionalTimePoints).windowed(2).minOf {
                it.last() - it.first()
            }
        }

        private fun String.toHHMM(): Pair<Int, Int> {
            val split = this.split(":")
            return split.first().toInt() to split.last().toInt()
        }

        private operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> =
            (this.first + other.first) to (this.second + other.second)

        private operator fun Pair<Int, Int>.minus(other: Pair<Int, Int>): Int =
            if (this.second < other.second) {
                (this.first - other.first - 1) * 60 + this.second + 60 - other.second
            } else {
                (this.first - other.first) * 60 + this.second - other.second
            }
    }
}

package me.bossm0n5t3r.leetcode.relativeRanks

class RelativeRanks {
    class Solution {
        fun findRelativeRanks(score: IntArray): Array<String> {
            val scoreToRank =
                score
                    .sortedDescending()
                    .mapIndexed { index, score ->
                        score to
                            when (index) {
                                0 -> "Gold Medal"
                                1 -> "Silver Medal"
                                2 -> "Bronze Medal"
                                else -> "${index + 1}"
                            }
                    }
                    .toMap()
            return score.toList().mapNotNull { scoreToRank[it] }.toTypedArray()
        }
    }
}

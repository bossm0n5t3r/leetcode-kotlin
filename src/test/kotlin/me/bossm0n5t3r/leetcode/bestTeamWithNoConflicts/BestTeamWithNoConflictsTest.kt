package me.bossm0n5t3r.leetcode.bestTeamWithNoConflicts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BestTeamWithNoConflictsTest {
    private val bestTeamWithNoConflicts = BestTeamWithNoConflicts.Solution()

    private data class BestTeamWithNoConflictsTestData(
        val scores: IntArray,
        val ages: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as BestTeamWithNoConflictsTestData

            if (!scores.contentEquals(other.scores)) return false
            if (!ages.contentEquals(other.ages)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = scores.contentHashCode()
            result1 = 31 * result1 + ages.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun bestTeamScore() {
        val tests =
            listOf(
                BestTeamWithNoConflictsTestData(
                    intArrayOf(1, 3, 5, 10, 15),
                    intArrayOf(1, 2, 3, 4, 5),
                    34,
                ),
                BestTeamWithNoConflictsTestData(intArrayOf(4, 5, 6, 5), intArrayOf(2, 1, 2, 1), 16),
                BestTeamWithNoConflictsTestData(intArrayOf(1, 2, 3, 5), intArrayOf(8, 9, 10, 1), 6),
                BestTeamWithNoConflictsTestData(
                    intArrayOf(
                        319776,
                        611683,
                        835240,
                        602298,
                        430007,
                        574,
                        142444,
                        858606,
                        734364,
                        896074,
                    ),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    5431066,
                ),
                BestTeamWithNoConflictsTestData(
                    intArrayOf(6, 5, 1, 7, 6, 5, 5, 4, 10, 4),
                    intArrayOf(3, 2, 5, 3, 2, 1, 4, 4, 5, 1),
                    43,
                ),
            )
        tests.forEach { test ->
            val result = bestTeamWithNoConflicts.bestTeamScore(test.scores, test.ages)
            assertEquals(test.result, result)
        }
    }
}

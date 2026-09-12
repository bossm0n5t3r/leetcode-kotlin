package me.bossm0n5t3r.leetcode.maximumscoreofnonoverlappingintervals

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreOfNonOverlappingIntervalsTest {
    private val sut = MaximumScoreOfNonOverlappingIntervals.Solution()

    private data class TestData(val intervals: List<List<Int>>, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (intervals != other.intervals) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = intervals.hashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]".toListOfIntList(),
                    intArrayOf(2, 3),
                ),
                TestData(
                    "[[5,8,1],[6,7,7],[4,7,3],[9,10,6],[7,8,2],[11,14,3],[3,5,5]]"
                        .toListOfIntList(),
                    intArrayOf(1, 3, 5, 6),
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result.toList(), sut.maximumWeight(testData.intervals).toList())
        }
    }
}

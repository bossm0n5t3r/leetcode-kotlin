package me.bossm0n5t3r.leetcode.mergeintervals

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeIntervalsTest {
    private val sut = MergeIntervals.Solution()

    private data class TestData(val intervals: Array<IntArray>, val result: Array<IntArray>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!intervals.contentDeepEquals(other.intervals)) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = intervals.contentDeepHashCode()
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[1,3],[2,6],[8,10],[15,18]]".toArrayOfIntArray(),
                    "[[1,6],[8,10],[15,18]]".toArrayOfIntArray(),
                ),
                TestData("[[1,4],[4,5]]".toArrayOfIntArray(), "[[1,5]]".toArrayOfIntArray()),
                TestData("[[4,7],[1,4]]".toArrayOfIntArray(), "[[1,7]]".toArrayOfIntArray()),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.map { it.toList() },
                sut.merge(testData.intervals).map { it.toList() },
            )
        }
    }
}

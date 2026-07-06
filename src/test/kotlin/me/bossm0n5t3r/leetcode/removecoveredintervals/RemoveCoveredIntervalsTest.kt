package me.bossm0n5t3r.leetcode.removecoveredintervals

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveCoveredIntervalsTest {
    private val sut = RemoveCoveredIntervals.Solution()

    private data class TestData(val intervals: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!intervals.contentDeepEquals(other.intervals)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + intervals.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[1,4],[3,6],[2,8]]".toArrayOfIntArray(), 2),
                TestData("[[1,4],[2,3]]".toArrayOfIntArray(), 1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.removeCoveredIntervals(testData.intervals))
        }
    }
}

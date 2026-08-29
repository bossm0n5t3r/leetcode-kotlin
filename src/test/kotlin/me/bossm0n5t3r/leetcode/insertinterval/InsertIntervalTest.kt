package me.bossm0n5t3r.leetcode.insertinterval

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InsertIntervalTest {
    private val sut = InsertInterval.Solution()

    private data class TestData(
        val intervals: Array<IntArray>,
        val newInterval: IntArray,
        val result: Array<IntArray>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!intervals.contentDeepEquals(other.intervals)) return false
            if (!newInterval.contentEquals(other.newInterval)) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = intervals.contentDeepHashCode()
            result1 = 31 * result1 + newInterval.contentHashCode()
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[1,3],[6,9]]".toArrayOfIntArray(),
                    intArrayOf(2, 5),
                    "[[1,5],[6,9]]".toArrayOfIntArray(),
                ),
                TestData(
                    "[[1,2],[3,5],[6,7],[8,10],[12,16]]".toArrayOfIntArray(),
                    intArrayOf(4, 8),
                    "[[1,2],[3,10],[12,16]]".toArrayOfIntArray(),
                ),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.map { it.toList() },
                sut.insert(testData.intervals, testData.newInterval).map { it.toList() },
            )
        }
    }
}

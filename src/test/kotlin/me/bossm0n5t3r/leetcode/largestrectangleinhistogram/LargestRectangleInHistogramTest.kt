package me.bossm0n5t3r.leetcode.largestrectangleinhistogram

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestRectangleInHistogramTest {
    private val sut = LargestRectangleInHistogram.Solution()

    private data class TestData(val heights: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!heights.contentEquals(other.heights)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + heights.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 1, 5, 6, 2, 3), 10),
                TestData(intArrayOf(2, 4), 4),
                TestData(intArrayOf(1, 1), 2),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.largestRectangleArea(testData.heights))
        }
    }
}

package me.bossm0n5t3r.leetcode.maximumalternatingsumofsquares

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAlternatingSumOfSquaresTest {
    private val sut = MaximumAlternatingSumOfSquares.Solution()

    private class TestData(val nums: IntArray, val result: Long)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3), 12L),
                TestData(intArrayOf(1, -1, 2, -2, 3, -3), 16L),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxAlternatingSum(testData.nums))
        }
    }
}

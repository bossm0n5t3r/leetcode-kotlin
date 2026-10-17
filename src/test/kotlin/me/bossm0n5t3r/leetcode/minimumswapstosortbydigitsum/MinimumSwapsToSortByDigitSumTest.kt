package me.bossm0n5t3r.leetcode.minimumswapstosortbydigitsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSwapsToSortByDigitSumTest {
    private val sut = MinimumSwapsToSortByDigitSum.Solution()

    private class TestData(val nums: IntArray, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(37, 100), 1),
                TestData(intArrayOf(22, 14, 33, 7), 0),
                TestData(intArrayOf(18, 43, 34, 16), 2),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minSwaps(testData.nums))
        }
    }
}

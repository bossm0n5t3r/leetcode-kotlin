package me.bossm0n5t3r.leetcode.subarraysdistinctelementsumofsquaresii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubarraysDistinctElementSumOfSquaresIITest {
    private val sut = SubarraysDistinctElementSumOfSquaresII.Solution()

    private class TestData(val nums: IntArray, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(intArrayOf(1, 2, 1), 15), TestData(intArrayOf(2, 2), 3))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.sumCounts(testData.nums))
        }
    }
}

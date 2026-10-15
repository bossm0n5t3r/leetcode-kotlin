package me.bossm0n5t3r.leetcode.subarraysdistinctelementsumofsquaresi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubarraysDistinctElementSumOfSquaresITest {
    private val sut = SubarraysDistinctElementSumOfSquaresI.Solution()

    private class TestData(val nums: List<Int>, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(listOf(1, 2, 1), 15), TestData(listOf(1, 1), 3))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.sumCounts(testData.nums))
        }
    }
}

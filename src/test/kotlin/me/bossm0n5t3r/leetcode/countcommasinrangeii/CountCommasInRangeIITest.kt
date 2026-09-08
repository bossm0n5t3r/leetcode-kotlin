package me.bossm0n5t3r.leetcode.countcommasinrangeii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCommasInRangeIITest {
    private val sut = CountCommasInRangeII.Solution()

    private data class TestData(val n: Long, val result: Long)

    @Test
    fun test() {
        val testDataList = listOf(TestData(1002, 3), TestData(998, 0))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countCommas(testData.n))
        }
    }
}

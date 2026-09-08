package me.bossm0n5t3r.leetcode.countcommasinrange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCommasInRangeTest {
    private val sut = CountCommasInRange.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(1002, 3), TestData(998, 0), TestData(2019, 1020))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countCommas(testData.n))
        }
    }
}

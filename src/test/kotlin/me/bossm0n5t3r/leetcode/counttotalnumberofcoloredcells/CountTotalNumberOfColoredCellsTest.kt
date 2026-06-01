package me.bossm0n5t3r.leetcode.counttotalnumberofcoloredcells

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTotalNumberOfColoredCellsTest {
    private val sut = CountTotalNumberOfColoredCells.Solution()

    private data class TestData(val n: Int, val result: Long)

    @Test
    fun test() {
        val testDataList = listOf(TestData(1, 1), TestData(2, 5))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.coloredCells(testData.n))
        }
    }
}

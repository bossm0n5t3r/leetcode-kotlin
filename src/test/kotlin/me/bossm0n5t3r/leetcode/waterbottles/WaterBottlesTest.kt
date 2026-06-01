package me.bossm0n5t3r.leetcode.waterbottles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaterBottlesTest {
    private val sut = WaterBottles.Solution()

    private data class TestData(val numBottles: Int, val numExchange: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(9, 3, 13), TestData(15, 4, 19))

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.numWaterBottles(testData.numBottles, testData.numExchange),
            )
        }
    }
}

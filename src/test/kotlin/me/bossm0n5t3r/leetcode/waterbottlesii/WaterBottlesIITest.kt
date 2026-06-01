package me.bossm0n5t3r.leetcode.waterbottlesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaterBottlesIITest {
    private val sut = WaterBottlesII.Solution()

    private data class TestData(val numBottles: Int, val numExchange: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(13, 6, 15), TestData(10, 3, 13))

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.maxBottlesDrunk(testData.numBottles, testData.numExchange),
            )
        }
    }
}

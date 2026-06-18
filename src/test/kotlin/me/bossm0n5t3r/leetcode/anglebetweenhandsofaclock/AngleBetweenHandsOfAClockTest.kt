package me.bossm0n5t3r.leetcode.anglebetweenhandsofaclock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AngleBetweenHandsOfAClockTest {
    private val sut = AngleBetweenHandsOfAClock.Solution()

    private data class TestData(val hour: Int, val minutes: Int, val result: Double)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(12, 30, 165.0),
                TestData(3, 30, 75.0),
                TestData(3, 15, 7.5),
                TestData(1, 57, 76.5),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.angleClock(testData.hour, testData.minutes))
        }
    }
}

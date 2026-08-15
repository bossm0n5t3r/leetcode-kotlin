package me.bossm0n5t3r.leetcode.numberofelapsedsecondsbetweentwotimes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfElapsedSecondsBetweenTwoTimesTest {
    private val sut = NumberOfElapsedSecondsBetweenTwoTimes.Solution()

    private data class TestData(val startTime: String, val endTime: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("01:00:00", "01:00:25", 25), TestData("12:34:56", "13:00:00", 1504))

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.secondsBetweenTimes(testData.startTime, testData.endTime),
            )
        }
    }
}

package me.bossm0n5t3r.leetcode.minimumtimedifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeDifferenceTest {
    private val sut = MinimumTimeDifference.Solution()

    private data class TestData(val timePoints: List<String>, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(listOf("23:59", "00:00"), 1),
                TestData(listOf("00:00", "23:59", "00:00"), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.findMinDifference(testData.timePoints))
        }
    }
}

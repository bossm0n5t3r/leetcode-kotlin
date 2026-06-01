package me.bossm0n5t3r.leetcode.maximumscoreaftersplittingastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreAfterSplittingAStringTest {
    private val sut = MaximumScoreAfterSplittingAString.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("011101", 5), TestData("00111", 5), TestData("1111", 3))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxScore(testData.s))
        }
    }
}

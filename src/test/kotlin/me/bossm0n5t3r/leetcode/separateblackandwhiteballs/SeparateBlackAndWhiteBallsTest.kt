package me.bossm0n5t3r.leetcode.separateblackandwhiteballs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SeparateBlackAndWhiteBallsTest {
    private val sut = SeparateBlackAndWhiteBalls.Solution()

    private data class TestData(val s: String, val result: Long)

    @Test
    fun test() {
        val testDataList = listOf(TestData("101", 1), TestData("100", 2), TestData("0111", 0))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minimumSteps(testData.s))
        }
    }
}

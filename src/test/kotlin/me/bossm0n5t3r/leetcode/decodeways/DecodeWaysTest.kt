package me.bossm0n5t3r.leetcode.decodeways

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeWaysTest {
    private val sut = DecodeWays.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("12", 2), TestData("226", 3), TestData("06", 0))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numDecodings(testData.s))
        }
    }
}

package me.bossm0n5t3r.leetcode.maximizeactivesectionwithtradei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeActiveSectionWithTradeITest {
    private val sut = MaximizeActiveSectionWithTradeI.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("01", 1),
                TestData("0100", 4),
                TestData("1000100", 7),
                TestData("01010", 4),
                TestData("01101001", 7),
                TestData("010101100", 7),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxActiveSectionsAfterTrade(testData.s))
        }
    }
}

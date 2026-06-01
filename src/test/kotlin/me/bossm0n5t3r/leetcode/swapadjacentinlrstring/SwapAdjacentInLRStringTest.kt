package me.bossm0n5t3r.leetcode.swapadjacentinlrstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SwapAdjacentInLRStringTest {
    private val sut = SwapAdjacentInLRString.Solution()

    private data class TestData(val start: String, val result: String, val answer: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("RXXLRXRXL", "XRLXXRRLX", true), TestData("X", "L", false))

        for (testData in testDataList) {
            assertEquals(testData.answer, sut.canTransform(testData.start, testData.result))
        }
    }
}

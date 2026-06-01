package me.bossm0n5t3r.leetcode.checkifastringcontainsallbinarycodesofsizek

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfAStringContainsAllBinaryCodesOfSizeKTest {
    private val sut = CheckIfAStringContainsAllBinaryCodesOfSizeK.Solution()

    private data class TestData(val s: String, val k: Int, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("00110110", 2, true),
                TestData("0110", 1, true),
                TestData("0110", 2, false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.hasAllCodes(testData.s, testData.k))
        }
    }
}

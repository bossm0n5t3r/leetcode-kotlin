package me.bossm0n5t3r.leetcode.concatenatenonzerodigitsandmultiplybysumi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcatenateNonZeroDigitsAndMultiplyBySumITest {
    private val sut = ConcatenateNonZeroDigitsAndMultiplyBySumI.Solution()

    private data class TestData(val n: Int, val result: Long)

    @Test
    fun test() {
        val testDataList = listOf(TestData(10203004, 12340), TestData(1000, 1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.sumAndMultiply(testData.n))
        }
    }
}

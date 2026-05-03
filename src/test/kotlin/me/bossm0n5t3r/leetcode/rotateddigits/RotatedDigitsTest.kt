package me.bossm0n5t3r.leetcode.rotateddigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RotatedDigitsTest {
    private val sut = RotatedDigits.Solution()

    private data class TestData(
        val n: Int,
        val result: Int,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(10, 4),
                TestData(1, 0),
                TestData(2, 1),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.rotatedDigits(testData.n),
            )
        }
    }
}

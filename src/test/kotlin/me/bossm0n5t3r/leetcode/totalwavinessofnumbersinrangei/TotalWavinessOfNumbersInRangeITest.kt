package me.bossm0n5t3r.leetcode.totalwavinessofnumbersinrangei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalWavinessOfNumbersInRangeITest {
    private val sut = TotalWavinessOfNumbersInRangeI.Solution()

    private data class TestData(val num1: Int, val num2: Int, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(120, 130, 3),
                TestData(198, 202, 3),
                TestData(4848, 4848, 2),
                TestData(9972, 9999, 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.totalWaviness(testData.num1, testData.num2))
        }
    }
}

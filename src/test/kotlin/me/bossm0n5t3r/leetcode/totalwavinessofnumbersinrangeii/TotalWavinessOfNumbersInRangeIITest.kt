package me.bossm0n5t3r.leetcode.totalwavinessofnumbersinrangeii

import me.bossm0n5t3r.leetcode.totalwavinessofnumbersinrangei.TotalWavinessOfNumbersInRangeITest.TestData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalWavinessOfNumbersInRangeIITest {
    private val sut = TotalWavinessOfNumbersInRangeII.Solution()

    private data class TestData(val num1: Long, val num2: Long, val result: Long)

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

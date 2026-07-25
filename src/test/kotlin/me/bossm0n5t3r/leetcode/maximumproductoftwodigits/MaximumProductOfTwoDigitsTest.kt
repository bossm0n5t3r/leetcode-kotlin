package me.bossm0n5t3r.leetcode.maximumproductoftwodigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTwoDigitsTest {
    private val sut = MaximumProductOfTwoDigits.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(31, 3), TestData(22, 4), TestData(124, 8))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxProduct(testData.n))
        }
    }
}

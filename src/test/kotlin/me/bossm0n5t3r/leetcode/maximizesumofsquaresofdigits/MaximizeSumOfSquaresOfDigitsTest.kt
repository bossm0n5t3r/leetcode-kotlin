package me.bossm0n5t3r.leetcode.maximizesumofsquaresofdigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeSumOfSquaresOfDigitsTest {
    private val sut = MaximizeSumOfSquaresOfDigits.Solution()

    private class TestData(val num: Int, val sum: Int, val result: String)

    @Test
    fun test() {
        val testDataList = listOf(TestData(2, 3, "30"), TestData(2, 17, "98"), TestData(1, 10, ""))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxSumOfSquares(testData.num, testData.sum))
        }
    }
}

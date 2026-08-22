package me.bossm0n5t3r.leetcode.checkdivisibilitybydigitsumandproduct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckDivisibilityByDigitSumAndProductTest {
    private val sut = CheckDivisibilityByDigitSumAndProduct.Solution()

    private data class TestData(val n: Int, val result: Boolean)

    @Test
    fun test() {
        val testDataList = listOf(TestData(99, true), TestData(23, false))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.checkDivisibility(testData.n))
        }
    }
}

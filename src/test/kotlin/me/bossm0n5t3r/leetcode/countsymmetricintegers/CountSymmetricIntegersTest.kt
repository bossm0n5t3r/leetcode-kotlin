package me.bossm0n5t3r.leetcode.countsymmetricintegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSymmetricIntegersTest {
    private val sut = CountSymmetricIntegers.Solution()

    private data class TestData(val low: Int, val high: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(1, 100, 9), TestData(1200, 1230, 4))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countSymmetricIntegers(testData.low, testData.high))
        }
    }
}

package me.bossm0n5t3r.leetcode.binarygap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryGapTest {
    private val sut = BinaryGap.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(22, 2), TestData(8, 0), TestData(5, 2))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.binaryGap(testData.n))
        }
    }
}

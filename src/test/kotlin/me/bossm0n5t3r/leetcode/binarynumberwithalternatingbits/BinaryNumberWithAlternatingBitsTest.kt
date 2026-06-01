package me.bossm0n5t3r.leetcode.binarynumberwithalternatingbits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryNumberWithAlternatingBitsTest {
    private val sut = BinaryNumberWithAlternatingBits.Solution()

    private data class TestData(val n: Int, val result: Boolean)

    @Test
    fun test() {
        val testDataList = listOf(TestData(5, true), TestData(7, false), TestData(11, false))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.hasAlternatingBits(testData.n))
        }
    }
}

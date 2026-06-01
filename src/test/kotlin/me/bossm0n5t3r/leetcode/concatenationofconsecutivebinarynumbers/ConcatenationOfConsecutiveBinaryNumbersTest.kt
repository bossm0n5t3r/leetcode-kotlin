package me.bossm0n5t3r.leetcode.concatenationofconsecutivebinarynumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcatenationOfConsecutiveBinaryNumbersTest {
    private val sut = ConcatenationOfConsecutiveBinaryNumbers.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(1, 1), TestData(3, 27), TestData(12, 505379714))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.concatenatedBinary(testData.n))
        }
    }
}

package me.bossm0n5t3r.leetcode.gcdofoddandevensums

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GCDOfOddAndEvenSumsTest {
    private val sut = GCDOfOddAndEvenSums.Solution()

    private data class TestData(val n: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(4, 4), TestData(5, 5))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.gcdOfOddEvenSums(testData.n))
        }
    }
}

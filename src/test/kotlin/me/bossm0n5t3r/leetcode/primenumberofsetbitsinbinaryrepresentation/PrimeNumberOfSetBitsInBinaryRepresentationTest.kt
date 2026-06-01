package me.bossm0n5t3r.leetcode.primenumberofsetbitsinbinaryrepresentation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimeNumberOfSetBitsInBinaryRepresentationTest {
    private val sut = PrimeNumberOfSetBitsInBinaryRepresentation.Solution()

    private data class TestData(val left: Int, val right: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(6, 10, 4), TestData(10, 15, 5))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countPrimeSetBits(testData.left, testData.right))
        }
    }
}

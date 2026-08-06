package me.bossm0n5t3r.leetcode.smallestdivisibledigitproducti

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestDivisibleDigitProductITest {
    private val sut = SmallestDivisibleDigitProductI.Solution()

    private data class TestData(val n: Int, val t: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(10, 2, 10), TestData(15, 3, 16))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.smallestNumber(testData.n, testData.t))
        }
    }
}

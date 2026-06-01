package me.bossm0n5t3r.leetcode.findallpossiblestablebinaryarraysi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAllPossibleStableBinaryArraysITest {
    private val sut = FindAllPossibleStableBinaryArraysI.Solution()

    private data class TestData(val zero: Int, val one: Int, val limit: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(1, 1, 2, 2), TestData(1, 2, 1, 1), TestData(3, 3, 2, 14))

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.numberOfStableArrays(testData.zero, testData.one, testData.limit),
            )
        }
    }
}

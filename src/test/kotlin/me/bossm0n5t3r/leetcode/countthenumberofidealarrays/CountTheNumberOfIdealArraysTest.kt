package me.bossm0n5t3r.leetcode.countthenumberofidealarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfIdealArraysTest {
    private val sut = CountTheNumberOfIdealArrays.Solution()

    private data class TestData(val n: Int, val maxValue: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(2, 5, 10), TestData(5, 3, 11))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.idealArrays(testData.n, testData.maxValue))
        }
    }
}

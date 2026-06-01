package me.bossm0n5t3r.leetcode.countbinarysubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountBinarySubstringsTest {
    private val sut = CountBinarySubstrings.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("00110011", 6), TestData("10101", 4))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countBinarySubstrings(testData.s))
        }
    }
}

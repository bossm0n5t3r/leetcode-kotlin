package me.bossm0n5t3r.leetcode.shortestandlexicographicallysmallestbeautifulstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestAndLexicographicallySmallestBeautifulStringTest {
    private val sut = ShortestAndLexicographicallySmallestBeautifulString.Solution()

    private data class TestData(val s: String, val k: Int, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("100011001", 3, "11001"),
                TestData("1011", 2, "11"),
                TestData("000", 1, ""),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.shortestBeautifulSubstring(testData.s, testData.k))
        }
    }
}

package me.bossm0n5t3r.leetcode.smallestsubsequenceofdistinctcharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestSubsequenceOfDistinctCharactersTest {
    private val sut = SmallestSubsequenceOfDistinctCharacters.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList = listOf(TestData("bcabc", "abc"), TestData("cbacdcbc", "acdb"))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.smallestSubsequence(testData.s))
        }
    }
}

package me.bossm0n5t3r.leetcode.maximumlengthsubstringwithtwooccurrences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLengthSubstringWithTwoOccurrencesTest {
    private val sut = MaximumLengthSubstringWithTwoOccurrences.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("bcbbbcba", 4), TestData("aaaa", 2))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maximumLengthSubstring(testData.s))
        }
    }
}

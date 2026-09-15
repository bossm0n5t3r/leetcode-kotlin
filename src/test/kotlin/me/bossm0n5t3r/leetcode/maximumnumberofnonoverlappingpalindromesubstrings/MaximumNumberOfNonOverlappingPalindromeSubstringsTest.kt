package me.bossm0n5t3r.leetcode.maximumnumberofnonoverlappingpalindromesubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfNonOverlappingPalindromeSubstringsTest {
    private val sut = MaximumNumberOfNonOverlappingPalindromeSubstrings.Solution()

    private class TestData(val s: String, val k: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("abaccdbbd", 3, 2), TestData("adbcda", 2, 0))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxPalindromes(testData.s, testData.k))
        }
    }
}

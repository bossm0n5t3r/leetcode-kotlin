package me.bossm0n5t3r.leetcode.longestbalancedsubstringii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubstringIITest {
    private val sut = LongestBalancedSubstringII.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("abbac", 4), TestData("aabcc", 3), TestData("aba", 2))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.longestBalanced(testData.s))
        }
    }
}

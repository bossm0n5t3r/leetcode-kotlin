package me.bossm0n5t3r.leetcode.smallestpalindromicrearrangementii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestPalindromicRearrangementIITest {
    private val sut = SmallestPalindromicRearrangementII.Solution()

    private data class TestData(val s: String, val k: Int, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abba", 2, "baab"),
                TestData("aa", 2, ""),
                TestData("bacab", 1, "abcba"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.smallestPalindrome(testData.s, testData.k))
        }
    }
}

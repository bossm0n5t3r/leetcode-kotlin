package me.bossm0n5t3r.leetcode.longestCommonSubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonSubsequenceTest {
    private val sut = LongestCommonSubsequence.Solution()

    private data class TestData(val text1: String, val text2: String, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("abcde", "ace", 3),
                TestData("abc", "abc", 3),
                TestData("abc", "def", 0),
            )

        tests.forEach { test ->
            assertEquals(sut.longestCommonSubsequence(test.text1, test.text2), test.result)
        }
    }
}

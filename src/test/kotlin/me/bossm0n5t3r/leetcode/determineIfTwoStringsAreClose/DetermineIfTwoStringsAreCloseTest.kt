package me.bossm0n5t3r.leetcode.determineIfTwoStringsAreClose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DetermineIfTwoStringsAreCloseTest {
    private val sut = DetermineIfTwoStringsAreClose.Solution()

    private data class TestData(val word1: String, val word2: String, val result: Boolean)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(word1 = "abc", word2 = "bca", result = true),
                TestData(word1 = "a", word2 = "aa", result = false),
                TestData(word1 = "cabbba", word2 = "abbccc", result = true),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.closeStrings(test.word1, test.word2))
        }
    }
}

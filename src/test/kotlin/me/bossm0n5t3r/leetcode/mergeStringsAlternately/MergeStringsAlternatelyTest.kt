package me.bossm0n5t3r.leetcode.mergeStringsAlternately

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeStringsAlternatelyTest {
    private val sut = MergeStringsAlternately.Solution()

    private data class TestData(val word1: String, val word2: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("abc", "pqr", "apbqcr"),
                TestData("ab", "pqrs", "apbqrs"),
                TestData("abcd", "pq", "apbqcd"),
            )
        tests.forEach { test ->
            assertEquals(test.result, sut.mergeAlternately(test.word1, test.word2))
        }
    }
}

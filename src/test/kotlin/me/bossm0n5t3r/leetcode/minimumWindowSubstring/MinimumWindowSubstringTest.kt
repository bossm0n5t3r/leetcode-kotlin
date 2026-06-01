package me.bossm0n5t3r.leetcode.minimumWindowSubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumWindowSubstringTest {
    private val sut = MinimumWindowSubstring.Solution()

    private data class TestData(val s: String, val t: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("ADOBECODEBANC", "ABC", "BANC"),
                TestData("a", "a", "a"),
                TestData("a", "aa", ""),
            )

        tests.forEach { test -> assertEquals(test.result, sut.minWindow(test.s, test.t)) }
    }
}

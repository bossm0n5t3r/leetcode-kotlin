package me.bossm0n5t3r.leetcode.appendCharactersToStringToMakeSubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AppendCharactersToStringToMakeSubsequenceTest {
    private val sut = AppendCharactersToStringToMakeSubsequence.Solution()

    private data class TestData(val s: String, val t: String, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("coaching", "coding", 4),
                TestData("abcde", "a", 0),
                TestData("z", "abcde", 5),
            )

        tests.forEach { test -> assertEquals(test.result, sut.appendCharacters(test.s, test.t)) }
    }
}

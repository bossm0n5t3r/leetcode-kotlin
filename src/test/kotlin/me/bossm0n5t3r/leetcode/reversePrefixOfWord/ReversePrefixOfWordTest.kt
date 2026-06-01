package me.bossm0n5t3r.leetcode.reversePrefixOfWord

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReversePrefixOfWordTest {
    private val sut = ReversePrefixOfWord.Solution()

    private data class TestData(val word: String, val ch: Char, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("abcdefd", 'd', "dcbaefd"),
                TestData("xyxzxe", 'z', "zxyxxe"),
                TestData("abcd", 'z', "abcd"),
            )

        tests.forEach { test -> assertEquals(test.result, sut.reversePrefix(test.word, test.ch)) }
    }
}

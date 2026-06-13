package me.bossm0n5t3r.leetcode.reverseWordsInAString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseWordsInAStringTest {
    private val sut = ReverseWordsInAString.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("the sky is blue", "blue is sky the"),
                TestData("  hello world  ", "world hello"),
            )

        tests.forEach { test -> assertEquals(test.result, sut.reverseWords(test.s)) }
    }
}

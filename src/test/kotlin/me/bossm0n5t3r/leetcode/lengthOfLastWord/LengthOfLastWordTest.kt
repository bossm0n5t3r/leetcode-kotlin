package me.bossm0n5t3r.leetcode.lengthOfLastWord

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLastWordTest {
    private val sut = LengthOfLastWord.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("Hello World", 5),
                TestData("   fly me   to   the moon  ", 4),
                TestData("luffy is still joyboy", 6),
            )

        tests.forEach { test -> assertEquals(test.result, sut.lengthOfLastWord(test.s)) }
    }
}

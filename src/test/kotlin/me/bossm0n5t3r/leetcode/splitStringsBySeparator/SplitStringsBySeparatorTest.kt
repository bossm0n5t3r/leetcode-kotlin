package me.bossm0n5t3r.leetcode.splitStringsBySeparator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SplitStringsBySeparatorTest {
    private val sut = SplitStringsBySeparator.Solution()

    private data class TestData(
        val words: List<String>,
        val separator: Char,
        val result: List<String>,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    listOf("one.two.three", "four.five", "six"),
                    '.',
                    listOf("one", "two", "three", "four", "five", "six"),
                ),
                TestData(listOf("\$easy$", "\$problem$"), '$', listOf("easy", "problem")),
                TestData(listOf("|||"), '|', emptyList()),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.splitWordsBySeparator(test.words, test.separator))
        }
    }
}

package me.bossm0n5t3r.leetcode.minimumRemoveToMakeValidParentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRemoveToMakeValidParenthesesTest {
    private val sut = MinimumRemoveToMakeValidParentheses.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("lee(t(c)o)de)", "lee(t(c)o)de"),
                TestData("a)b(c)d", "ab(c)d"),
                TestData("))((", ""),
            )

        tests.forEach { test -> assertEquals(test.result, sut.minRemoveToMakeValid(test.s)) }
    }
}

package me.bossm0n5t3r.leetcode.validParentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidParenthesesTest {
    private val validParentheses = ValidParentheses.Solution()

    data class ValidParenthesesTestData(val s: String, val result: Boolean)

    @Test
    fun isValid() {
        val tests =
            listOf(
                ValidParenthesesTestData("()", true),
                ValidParenthesesTestData("()[]{}", true),
                ValidParenthesesTestData("(]", false),
                ValidParenthesesTestData("([)]", false),
                ValidParenthesesTestData("{[]}", true),
            )
        tests.forEach { test -> assertEquals(validParentheses.isValid(test.s), test.result) }
    }
}

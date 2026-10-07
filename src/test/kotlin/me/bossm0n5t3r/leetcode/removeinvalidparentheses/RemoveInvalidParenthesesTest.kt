package me.bossm0n5t3r.leetcode.removeinvalidparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveInvalidParenthesesTest {
    private val sut = RemoveInvalidParentheses.Solution()

    private class TestData(val s: String, val result: List<String>)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("()())()", listOf("(())()", "()()()")),
                TestData("(a)())()", listOf("(a())()", "(a)()()")),
                TestData(")(", listOf("")),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.removeInvalidParentheses(testData.s))
        }
    }
}

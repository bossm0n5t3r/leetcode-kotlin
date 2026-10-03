package me.bossm0n5t3r.leetcode.longestvalidparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestValidParenthesesTest {
    private val sut = LongestValidParentheses.Solution()

    private class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("(()", 2), TestData(")()())", 4), TestData("", 0), TestData(")(", 0))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.longestValidParentheses(testData.s))
        }
    }
}

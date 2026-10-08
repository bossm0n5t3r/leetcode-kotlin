package me.bossm0n5t3r.leetcode.removeoutermostparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveOutermostParenthesesTest {
    private val sut = RemoveOutermostParentheses.Solution()

    private class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("(()())(())", "()()()"),
                TestData("(()())(())(()(()))", "()()()()(())"),
                TestData("()()", ""),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.removeOuterParentheses(testData.s))
        }
    }
}

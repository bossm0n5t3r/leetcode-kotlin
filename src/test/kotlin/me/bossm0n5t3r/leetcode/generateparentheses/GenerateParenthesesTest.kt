package me.bossm0n5t3r.leetcode.generateparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GenerateParenthesesTest {
    private val sut = GenerateParentheses.Solution()

    private class TestData(val n: Int, val result: List<String>)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(3, listOf("((()))", "(()())", "(())()", "()(())", "()()()")),
                TestData(1, listOf("()")),
                TestData(
                    4,
                    listOf(
                        "(((())))",
                        "((()()))",
                        "((())())",
                        "((()))()",
                        "(()(()))",
                        "(()()())",
                        "(()())()",
                        "(())(())",
                        "(())()()",
                        "()((()))",
                        "()(()())",
                        "()(())()",
                        "()()(())",
                        "()()()()",
                    ),
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.generateParenthesis(testData.n))
        }
    }
}

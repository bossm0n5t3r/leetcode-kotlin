package me.bossm0n5t3r.leetcode.parsingabooleanexpression

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ParsingABooleanExpressionTest {
    private val sut = ParsingABooleanExpression.Solution()

    private data class TestData(val expression: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("&(|(f))", false),
                TestData("|(f,f,f,t)", true),
                TestData("!(&(f,t))", true),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.parseBoolExpr(testData.expression))
        }
    }
}

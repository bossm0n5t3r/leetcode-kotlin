package me.bossm0n5t3r.leetcode.validparenthesisstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidParenthesisStringTest {
    private val sut = ValidParenthesisString.Solution()

    private class TestData(val s: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("()", true),
                TestData("(*)", true),
                TestData("(*))", true),
                TestData("(", false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.checkValidString(testData.s))
        }
    }
}

package me.bossm0n5t3r.leetcode.reversesubstringsbetweeneachpairofparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseSubstringsBetweenEachPairOfParenthesesTest {
    private val sut = ReverseSubstringsBetweenEachPairOfParentheses.Solution()

    private class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("(abcd)", "dcba"),
                TestData("(u(love)i)", "iloveu"),
                TestData("(ed(et(oc))el)", "leetcode"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.reverseParentheses(testData.s))
        }
    }
}

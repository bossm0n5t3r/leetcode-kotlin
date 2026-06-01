package me.bossm0n5t3r.leetcode.checkifaparenthesesstringcanbevalid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfAParenthesesStringCanBeValidTest {
    private val sut = CheckIfAParenthesesStringCanBeValid.Solution()

    private data class TestData(val s: String, val locked: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("))()))", "010100", true),
                TestData("()()", "0000", true),
                TestData(")", "0", false),
                TestData(")(", "00", true),
                TestData(
                    "((()(()()))()((()()))))()((()(()",
                    "10111100100101001110100010001001",
                    true,
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.canBeValid(testData.s, testData.locked))
        }
    }
}

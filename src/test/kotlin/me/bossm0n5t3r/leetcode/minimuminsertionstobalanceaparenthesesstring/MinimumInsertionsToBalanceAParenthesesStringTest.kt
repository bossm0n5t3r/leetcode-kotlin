package me.bossm0n5t3r.leetcode.minimuminsertionstobalanceaparenthesesstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumInsertionsToBalanceAParenthesesStringTest {
    private val sut = MinimumInsertionsToBalanceAParenthesesString.Solution()

    private class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("(()))", 1), TestData("())", 0), TestData("))())(", 3))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minInsertions(testData.s))
        }
    }
}

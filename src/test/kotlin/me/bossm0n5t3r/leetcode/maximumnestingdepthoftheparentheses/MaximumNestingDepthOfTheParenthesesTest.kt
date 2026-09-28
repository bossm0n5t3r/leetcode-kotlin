package me.bossm0n5t3r.leetcode.maximumnestingdepthoftheparentheses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNestingDepthOfTheParenthesesTest {
    private val sut = MaximumNestingDepthOfTheParentheses.Solution()

    private class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("(1+(2*3)+((8)/4))+1", 3),
                TestData("(1)+((2))+(((3)))", 3),
                TestData("()(())((()()))", 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxDepth(testData.s))
        }
    }
}

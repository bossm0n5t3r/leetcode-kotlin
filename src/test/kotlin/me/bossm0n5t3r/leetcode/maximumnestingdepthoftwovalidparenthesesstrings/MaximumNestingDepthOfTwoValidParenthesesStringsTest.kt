package me.bossm0n5t3r.leetcode.maximumnestingdepthoftwovalidparenthesesstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNestingDepthOfTwoValidParenthesesStringsTest {
    private val sut = MaximumNestingDepthOfTwoValidParenthesesStrings.Solution()

    private class TestData(val seq: String, val result: IntArray)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("(()())", intArrayOf(1, 0, 0, 0, 0, 1)),
                TestData("()(())()", intArrayOf(1, 1, 1, 0, 0, 1, 1, 1)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result.toList(), sut.maxDepthAfterSplit(testData.seq).toList())
        }
    }
}

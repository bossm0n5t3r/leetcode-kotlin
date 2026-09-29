package me.bossm0n5t3r.leetcode.checkifthereisavalidparenthesesstringpath

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfCharArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfThereIsAValidParenthesesStringPathTest {
    private val sut = CheckIfThereIsAValidParenthesesStringPath.Solution()

    private class TestData(val grid: Array<CharArray>, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[\"(\",\"(\",\"(\"],[\")\",\"(\",\")\"],[\"(\",\"(\",\")\"],[\"(\",\"(\",\")\"]]"
                        .toArrayOfCharArray(),
                    true,
                ),
                TestData("[[\")\",\")\"],[\"(\",\"(\"]]".toArrayOfCharArray(), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.hasValidPath(testData.grid))
        }
    }
}

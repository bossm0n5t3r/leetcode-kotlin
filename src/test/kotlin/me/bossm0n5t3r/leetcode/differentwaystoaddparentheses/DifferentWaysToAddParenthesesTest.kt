package me.bossm0n5t3r.leetcode.differentwaystoaddparentheses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DifferentWaysToAddParenthesesTest {
    private val sut = DifferentWaysToAddParentheses.Solution()

    private data class TestData(val expression: String, val result: List<Int>)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("2-1-1", listOf(0, 2)),
                TestData("2*3-4*5", listOf(-34, -14, -10, -10, 10)),
            )

        for (testData in testDataList) {
            assertThat(sut.diffWaysToCompute(testData.expression))
                .containsExactlyInAnyOrderElementsOf(testData.result)
        }
    }
}

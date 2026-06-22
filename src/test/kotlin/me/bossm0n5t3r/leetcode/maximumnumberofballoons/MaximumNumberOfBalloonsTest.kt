package me.bossm0n5t3r.leetcode.maximumnumberofballoons

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfBalloonsTest {
    private val sut = MaximumNumberOfBalloons.Solution()

    private data class TestData(val text: String, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("nlaebolko", 1),
                TestData("loonbalxballpoon", 2),
                TestData("leetcode", 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxNumberOfBalloons(testData.text))
        }
    }
}

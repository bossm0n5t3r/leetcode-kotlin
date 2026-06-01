package me.bossm0n5t3r.leetcode.circularsentence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CircularSentenceTest {
    private val sut = CircularSentence.Solution()

    private data class TestData(val sentence: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("leetcode exercises sound delightful", true),
                TestData("eetcode", true),
                TestData("Leetcode is cool", false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.isCircularSentence(testData.sentence))
        }
    }
}

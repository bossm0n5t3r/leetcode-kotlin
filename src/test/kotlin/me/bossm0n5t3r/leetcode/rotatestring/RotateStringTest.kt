package me.bossm0n5t3r.leetcode.rotatestring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RotateStringTest {
    private val sut = RotateString.Solution()

    private data class TestData(val s: String, val goal: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("abcde", "cdeab", true), TestData("abcde", "abced", false))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.rotateString(testData.s, testData.goal))
        }
    }
}

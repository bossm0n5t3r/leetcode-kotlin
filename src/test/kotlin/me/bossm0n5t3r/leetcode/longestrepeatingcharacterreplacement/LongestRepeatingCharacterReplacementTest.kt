package me.bossm0n5t3r.leetcode.longestrepeatingcharacterreplacement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestRepeatingCharacterReplacementTest {
    private val sut = LongestRepeatingCharacterReplacement.Solution()

    private data class TestData(val s: String, val k: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("ABAB", 2, 4), TestData("AABABBA", 1, 4))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.characterReplacement(testData.s, testData.k))
        }
    }
}

package me.bossm0n5t3r.leetcode.removealloccurrencesofasubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveAllOccurrencesOfASubstringTest {
    private val sut = RemoveAllOccurrencesOfASubstring.Solution()

    private data class TestData(val s: String, val part: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("daabcbaabcbc", "abc", "dab"), TestData("axxxxyyyyb", "xy", "ab"))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.removeOccurrences(testData.s, testData.part))
        }
    }
}

package me.bossm0n5t3r.leetcode.uniquelength3palindromicsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueLength3PalindromicSubsequencesTest {
    private val sut = UniqueLength3PalindromicSubsequences.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("aabca", 3), TestData("adc", 0), TestData("bbcbaba", 4))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countPalindromicSubsequence(testData.s))
        }
    }
}

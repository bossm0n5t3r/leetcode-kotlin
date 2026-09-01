package me.bossm0n5t3r.leetcode.palindromicsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PalindromicSubstringsTest {
    private val sut = PalindromicSubstrings.Solution()

    private data class PalindromicSubstringsTestData(val s: String, val result: Int)

    @Test
    fun countSubstrings() {
        val testDataList =
            listOf(PalindromicSubstringsTestData("abc", 3), PalindromicSubstringsTestData("aaa", 6))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countSubstrings(testData.s))
        }
    }
}

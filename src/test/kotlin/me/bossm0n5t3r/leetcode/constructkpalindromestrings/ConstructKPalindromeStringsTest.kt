package me.bossm0n5t3r.leetcode.constructkpalindromestrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructKPalindromeStringsTest {
    private val sut = ConstructKPalindromeStrings.Solution()

    private data class TestData(val s: String, val k: Int, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("annabelle", 2, true),
                TestData("leetcode", 3, false),
                TestData("true", 4, true),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.canConstruct(testData.s, testData.k))
        }
    }
}

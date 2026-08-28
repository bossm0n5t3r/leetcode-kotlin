package me.bossm0n5t3r.leetcode.lexicographicallysmallestpalindromicpermutationgreaterthantarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestPalindromicPermutationGreaterThanTargetTest {
    private val sut = LexicographicallySmallestPalindromicPermutationGreaterThanTarget.Solution()

    private data class TestData(val s: String, val target: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("baba", "abba", "baab"),
                TestData("baba", "bbaa", ""),
                TestData("abc", "abb", ""),
                TestData("aac", "abb", "aca"),
                TestData("aac", "aaa", "aca"),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.lexPalindromicPermutation(testData.s, testData.target),
            )
        }
    }
}

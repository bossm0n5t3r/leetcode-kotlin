package me.bossm0n5t3r.leetcode.lexicographicallysmallestpermutationgreaterthantarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestPermutationGreaterThanTargetTest {
    private val sut = LexicographicallySmallestPermutationGreaterThanTarget.Solution()

    private data class TestData(val s: String, val target: String, val result: String)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abc", "bba", "bca"),
                TestData("leet", "code", "eelt"),
                TestData("baba", "bbaa", ""),
                TestData("ab", "ab", "ba"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.lexGreaterPermutation(testData.s, testData.target))
        }
    }
}

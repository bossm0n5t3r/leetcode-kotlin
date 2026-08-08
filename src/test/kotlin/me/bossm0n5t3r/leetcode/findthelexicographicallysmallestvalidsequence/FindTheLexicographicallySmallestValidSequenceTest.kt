package me.bossm0n5t3r.leetcode.findthelexicographicallysmallestvalidsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLexicographicallySmallestValidSequenceTest {
    private val sut = FindTheLexicographicallySmallestValidSequence.Solution()

    private data class TestData(val word1: String, val word2: String, val result: IntArray)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("vbcca", "abc", intArrayOf(0, 1, 2)),
                TestData("bacdc", "abc", intArrayOf(1, 2, 4)),
                TestData("aaaaaa", "aaabc", intArrayOf()),
                TestData("abc", "ab", intArrayOf(0, 1)),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.validSequence(testData.word1, testData.word2).toList(),
            )
        }
    }
}

package me.bossm0n5t3r.leetcode.makestringasubsequenceusingcyclicincrements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MakeStringASubsequenceUsingCyclicIncrementsTest {
    private val sut = MakeStringASubsequenceUsingCyclicIncrements.Solution()

    private data class TestData(val str1: String, val str2: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("abc", "ad", true),
                TestData("zc", "ad", true),
                TestData("ab", "d", false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.canMakeSubsequence(testData.str1, testData.str2))
        }
    }
}

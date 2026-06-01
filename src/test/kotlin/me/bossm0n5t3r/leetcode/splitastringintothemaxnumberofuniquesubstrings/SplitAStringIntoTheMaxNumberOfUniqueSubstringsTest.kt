package me.bossm0n5t3r.leetcode.splitastringintothemaxnumberofuniquesubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SplitAStringIntoTheMaxNumberOfUniqueSubstringsTest {
    private val sut = SplitAStringIntoTheMaxNumberOfUniqueSubstrings.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("ababccc", 5), TestData("aba", 2), TestData("aa", 1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxUniqueSplit(testData.s))
        }
    }
}

package me.bossm0n5t3r.leetcode.maximumnumberofnonoverlappingsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfNonOverlappingSubstringsTest {
    private val sut = MaximumNumberOfNonOverlappingSubstrings.Solution()

    private class TestData(val s: String, val result: List<String>)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("adefaddaccc", listOf("e", "f", "ccc")),
                TestData("abbaccd", listOf("bb", "cc", "d")),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxNumOfSubstrings(testData.s))
        }
    }
}

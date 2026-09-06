package me.bossm0n5t3r.leetcode.distinctsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistinctSubsequencesTest {
    private val sut = DistinctSubsequences.Solution()

    private data class TestData(val s: String, val t: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("rabbbit", "rabbit", 3), TestData("babgbag", "bag", 5))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numDistinct(testData.s, testData.t))
        }
    }
}

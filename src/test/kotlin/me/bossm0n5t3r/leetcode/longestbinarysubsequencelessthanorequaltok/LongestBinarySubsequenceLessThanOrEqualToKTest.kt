package me.bossm0n5t3r.leetcode.longestbinarysubsequencelessthanorequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBinarySubsequenceLessThanOrEqualToKTest {
    private val sut = LongestBinarySubsequenceLessThanOrEqualToK.Solution()

    private data class TestData(val s: String, val k: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("1001010", 5, 5), TestData("00101001", 1, 6))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.longestSubsequence(testData.s, testData.k))
        }
    }
}

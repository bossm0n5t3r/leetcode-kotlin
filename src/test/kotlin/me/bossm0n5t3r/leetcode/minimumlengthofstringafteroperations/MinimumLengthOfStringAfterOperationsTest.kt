package me.bossm0n5t3r.leetcode.minimumlengthofstringafteroperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumLengthOfStringAfterOperationsTest {
    private val sut = MinimumLengthOfStringAfterOperations.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData("abaacbcbb", 5), TestData("aa", 2))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minimumLength(testData.s))
        }
    }
}

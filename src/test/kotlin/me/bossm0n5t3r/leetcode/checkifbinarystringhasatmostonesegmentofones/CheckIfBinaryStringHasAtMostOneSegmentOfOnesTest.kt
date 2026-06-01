package me.bossm0n5t3r.leetcode.checkifbinarystringhasatmostonesegmentofones

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {
    private val sut = CheckIfBinaryStringHasAtMostOneSegmentOfOnes.Solution()

    private data class TestData(val s: String, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("1001", false),
                TestData("110", true),
                TestData("1", true),
                TestData("10", true),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.checkOnesSegment(testData.s))
        }
    }
}

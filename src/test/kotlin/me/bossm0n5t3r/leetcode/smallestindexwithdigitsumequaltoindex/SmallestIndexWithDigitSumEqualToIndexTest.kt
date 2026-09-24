package me.bossm0n5t3r.leetcode.smallestindexwithdigitsumequaltoindex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestIndexWithDigitSumEqualToIndexTest {
    private val sut = SmallestIndexWithDigitSumEqualToIndex.Solution()

    private class TestData(val nums: IntArray, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 3, 2), 2),
                TestData(intArrayOf(1, 10, 11), 1),
                TestData(intArrayOf(1, 2, 3), -1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.smallestIndex(testData.nums))
        }
    }
}

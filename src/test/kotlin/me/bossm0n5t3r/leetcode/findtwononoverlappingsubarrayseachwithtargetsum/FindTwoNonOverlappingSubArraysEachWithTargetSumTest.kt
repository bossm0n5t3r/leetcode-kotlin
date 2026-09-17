package me.bossm0n5t3r.leetcode.findtwononoverlappingsubarrayseachwithtargetsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTwoNonOverlappingSubArraysEachWithTargetSumTest {
    private val sut = FindTwoNonOverlappingSubArraysEachWithTargetSum.Solution()

    private class TestData(val arr: IntArray, val target: Int, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(3, 2, 2, 4, 3), 3, 2),
                TestData(intArrayOf(7, 3, 4, 7), 7, 2),
                TestData(intArrayOf(4, 3, 2, 6, 2, 3, 4), 6, -1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minSumOfLengths(testData.arr, testData.target))
        }
    }
}

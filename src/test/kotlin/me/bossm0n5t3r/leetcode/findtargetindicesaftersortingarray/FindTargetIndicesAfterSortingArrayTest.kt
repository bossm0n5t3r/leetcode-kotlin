package me.bossm0n5t3r.leetcode.findtargetindicesaftersortingarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTargetIndicesAfterSortingArrayTest {
    private val sut = FindTargetIndicesAfterSortingArray.Solution()

    private class TestData(val nums: IntArray, val target: Int, val result: List<Int>)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 5, 2, 3), 2, listOf(1, 2)),
                TestData(intArrayOf(1, 2, 5, 2, 3), 3, listOf(3)),
                TestData(intArrayOf(1, 2, 5, 2, 3), 5, listOf(4)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.targetIndices(testData.nums, testData.target))
        }
    }
}

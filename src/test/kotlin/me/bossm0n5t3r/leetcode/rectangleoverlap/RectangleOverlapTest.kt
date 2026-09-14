package me.bossm0n5t3r.leetcode.rectangleoverlap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RectangleOverlapTest {
    private val sut = RectangleOverlap.Solution()

    private class TestData(val rec1: IntArray, val rec2: IntArray, val result: Boolean)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(0, 0, 2, 2), intArrayOf(1, 1, 3, 3), true),
                TestData(intArrayOf(0, 0, 1, 1), intArrayOf(1, 0, 2, 1), false),
                TestData(intArrayOf(0, 0, 1, 1), intArrayOf(2, 2, 3, 3), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.isRectangleOverlap(testData.rec1, testData.rec2))
        }
    }
}

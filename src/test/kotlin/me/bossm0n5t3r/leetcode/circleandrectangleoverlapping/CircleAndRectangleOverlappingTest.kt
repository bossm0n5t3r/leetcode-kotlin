package me.bossm0n5t3r.leetcode.circleandrectangleoverlapping

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CircleAndRectangleOverlappingTest {
    private val sut = CircleAndRectangleOverlapping.Solution()

    private class TestData(
        val radius: Int,
        val xCenter: Int,
        val yCenter: Int,
        val x1: Int,
        val y1: Int,
        val x2: Int,
        val y2: Int,
        val result: Boolean,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(1, 0, 0, 1, -1, 3, 1, true),
                TestData(1, 1, 1, 1, -3, 2, -1, false),
                TestData(1, 0, 0, -1, 0, 0, 1, true),
                TestData(1415, 807, -784, -733, 623, -533, 1005, false),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.checkOverlap(
                    testData.radius,
                    testData.xCenter,
                    testData.yCenter,
                    testData.x1,
                    testData.y1,
                    testData.x2,
                    testData.y2,
                ),
            )
        }
    }
}

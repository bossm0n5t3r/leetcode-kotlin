package me.bossm0n5t3r.leetcode.sumofsquaresofspecialelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfSquaresOfSpecialElementsTest {
    private val sut = SumOfSquaresOfSpecialElements.Solution()

    private class TestData(val nums: IntArray, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3, 4), 21),
                TestData(intArrayOf(2, 7, 1, 19, 18, 3), 63),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.sumOfSquares(testData.nums))
        }
    }
}

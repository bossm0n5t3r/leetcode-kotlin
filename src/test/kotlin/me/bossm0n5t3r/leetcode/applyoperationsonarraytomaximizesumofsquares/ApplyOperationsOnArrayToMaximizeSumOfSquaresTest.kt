package me.bossm0n5t3r.leetcode.applyoperationsonarraytomaximizesumofsquares

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ApplyOperationsOnArrayToMaximizeSumOfSquaresTest {
    private val sut = ApplyOperationsOnArrayToMaximizeSumOfSquares.Solution()

    private class TestData(val nums: List<Int>, val k: Int, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData(listOf(2, 6, 5, 8), 2, 261), TestData(listOf(4, 5, 4, 7), 3, 90))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxSum(testData.nums, testData.k))
        }
    }
}

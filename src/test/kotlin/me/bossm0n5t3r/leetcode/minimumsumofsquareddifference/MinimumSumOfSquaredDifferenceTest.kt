package me.bossm0n5t3r.leetcode.minimumsumofsquareddifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSumOfSquaredDifferenceTest {
    private val sut = MinimumSumOfSquaredDifference.Solution()

    private class TestData(
        val nums1: IntArray,
        val nums2: IntArray,
        val k1: Int,
        val k2: Int,
        val result: Long,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3, 4), intArrayOf(2, 10, 20, 19), 0, 0, 579),
                TestData(intArrayOf(1, 4, 10, 12), intArrayOf(5, 8, 6, 9), 1, 1, 43),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.minSumSquareDiff(testData.nums1, testData.nums2, testData.k1, testData.k2),
            )
        }
    }
}

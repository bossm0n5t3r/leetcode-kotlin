package me.bossm0n5t3r.leetcode.numberofwaystoreorderarraytogetsamebst

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToReorderArrayToGetSameBSTTest {
    private val sut = NumberOfWaysToReorderArrayToGetSameBST.Solution()

    private class TestData(val nums: IntArray, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 1, 3), 1),
                TestData(intArrayOf(3, 4, 5, 1, 2), 5),
                TestData(intArrayOf(1, 2, 3), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numOfWays(testData.nums))
        }
    }
}

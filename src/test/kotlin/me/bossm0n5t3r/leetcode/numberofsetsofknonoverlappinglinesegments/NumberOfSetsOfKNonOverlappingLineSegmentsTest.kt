package me.bossm0n5t3r.leetcode.numberofsetsofknonoverlappinglinesegments

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSetsOfKNonOverlappingLineSegmentsTest {
    private val sut = NumberOfSetsOfKNonOverlappingLineSegments.Solution()

    private class TestData(val n: Int, val k: Int, val result: Int)

    @Test
    fun test() {
        val testDataList = listOf(TestData(4, 2, 5), TestData(3, 1, 3), TestData(30, 7, 796297179))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numberOfSets(testData.n, testData.k))
            assertEquals(testData.result, sut.numberOfSetsByCombination(testData.n, testData.k))
        }
    }
}

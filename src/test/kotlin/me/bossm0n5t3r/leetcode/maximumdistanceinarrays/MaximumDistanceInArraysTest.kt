package me.bossm0n5t3r.leetcode.maximumdistanceinarrays

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDistanceInArraysTest {
    private val sut = MaximumDistanceInArrays.Solution()

    private data class TestData(val arrays: List<List<Int>>, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[1,2,3],[4,5],[1,2,3]]".toListOfIntList(), 4),
                TestData("[[1],[1]]".toListOfIntList(), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxDistance(testData.arrays))
        }
    }
}

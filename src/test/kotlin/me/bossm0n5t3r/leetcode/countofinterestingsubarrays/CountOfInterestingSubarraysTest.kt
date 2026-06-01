package me.bossm0n5t3r.leetcode.countofinterestingsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountOfInterestingSubarraysTest {
    private val sut = CountOfInterestingSubarrays.Solution()

    private data class TestData(val nums: List<Int>, val modulo: Int, val k: Int, val result: Long)

    @Test
    fun test() {
        val testDataList =
            listOf(TestData(listOf(3, 2, 4), 2, 1, 3), TestData(listOf(3, 1, 9, 6), 3, 0, 2))

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.countInterestingSubarrays(testData.nums, testData.modulo, testData.k),
            )
        }
    }
}

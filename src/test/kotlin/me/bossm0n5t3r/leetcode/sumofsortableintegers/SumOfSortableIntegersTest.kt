package me.bossm0n5t3r.leetcode.sumofsortableintegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfSortableIntegersTest {
    private val sut = SumOfSortableIntegers.Solution()

    private class TestData(val nums: IntArray, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(3, 1, 2), 3),
                TestData(intArrayOf(7, 6, 5), 0),
                TestData(intArrayOf(5, 8), 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.sortableIntegers(testData.nums))
        }
    }
}

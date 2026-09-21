package me.bossm0n5t3r.leetcode.findxvalueofarrayi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindXValueOfArrayITest {
    private val sut = FindXValueOfArrayI.Solution()

    private class TestData(val nums: IntArray, val k: Int, val result: LongArray)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3, 4, 5), 3, longArrayOf(9, 2, 4)),
                TestData(intArrayOf(1, 2, 4, 8, 16, 32), 4, longArrayOf(18, 1, 2, 0)),
                TestData(intArrayOf(1, 1, 2, 1, 1), 2, longArrayOf(9, 6)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.resultArray(testData.nums, testData.k))
        }
    }
}

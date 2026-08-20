package me.bossm0n5t3r.leetcode.distributeelementsintotwoarraysii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistributeElementsIntoTwoArraysIITest {
    private val sut = DistributeElementsIntoTwoArraysII.Solution()

    private data class TestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 1, 3, 3), intArrayOf(2, 3, 1, 3)),
                TestData(intArrayOf(5, 14, 3, 1, 2), intArrayOf(5, 3, 1, 2, 14)),
                TestData(intArrayOf(3, 3, 3, 3), intArrayOf(3, 3, 3, 3)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result.toList(), sut.resultArray(testData.nums).toList())
        }
    }
}

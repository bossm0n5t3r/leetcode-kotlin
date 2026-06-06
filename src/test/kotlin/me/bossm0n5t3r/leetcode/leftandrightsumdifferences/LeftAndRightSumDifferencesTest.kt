package me.bossm0n5t3r.leetcode.leftandrightsumdifferences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeftAndRightSumDifferencesTest {
    private val sut = LeftAndRightSumDifferences.Solution()

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
                TestData(intArrayOf(10, 4, 8, 3), intArrayOf(15, 1, 11, 22)),
                TestData(intArrayOf(1), intArrayOf(0)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result.toList(), sut.leftRightDifference(testData.nums).toList())
        }
    }
}

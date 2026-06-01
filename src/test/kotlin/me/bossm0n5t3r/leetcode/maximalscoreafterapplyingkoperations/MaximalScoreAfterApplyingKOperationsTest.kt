package me.bossm0n5t3r.leetcode.maximalscoreafterapplyingkoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximalScoreAfterApplyingKOperationsTest {
    private val sut = MaximalScoreAfterApplyingKOperations.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(10, 10, 10, 10, 10), 5, 50),
                TestData(intArrayOf(1, 10, 3, 3, 3), 3, 17),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxKelements(testData.nums, testData.k))
        }
    }
}

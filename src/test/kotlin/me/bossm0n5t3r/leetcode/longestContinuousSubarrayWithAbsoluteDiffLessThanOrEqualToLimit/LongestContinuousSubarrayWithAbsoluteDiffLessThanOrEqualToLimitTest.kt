package me.bossm0n5t3r.leetcode.longestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest {
    private val sut = LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit.Solution()

    private data class TestData(val nums: IntArray, val limit: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (limit != other.limit) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + limit
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(8, 2, 4, 7), 4, 2),
                TestData(intArrayOf(10, 1, 2, 4, 7, 2), 5, 4),
                TestData(intArrayOf(4, 2, 2, 2, 4, 4, 2, 2), 0, 3),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.longestSubarray(test.nums, test.limit))
        }
    }
}

package me.bossm0n5t3r.leetcode.maximumSubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubarrayTest {
    private val maximumSubarray = MaximumSubarray.Solution()

    data class MaximumSubarrayTestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MaximumSubarrayTestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun maxSubArray() {
        val tests =
            listOf(
                MaximumSubarrayTestData(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
                MaximumSubarrayTestData(intArrayOf(1), 1),
                MaximumSubarrayTestData(intArrayOf(5, 4, -1, 7, 8), 23),
            )
        tests.forEach { test -> assertEquals(test.result, maximumSubarray.maxSubArray(test.nums)) }
    }
}

package me.bossm0n5t3r.leetcode.shortestUnsortedContinuousSubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShortestUnsortedContinuousSubarrayTest {
    private val shortestUnsortedContinuousSubarray = ShortestUnsortedContinuousSubarray.Solution()

    private data class ShortestUnsortedContinuousSubarrayTestData(
        val nums: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ShortestUnsortedContinuousSubarrayTestData

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
    fun findUnsortedSubarray() {
        val tests =
            listOf(
                ShortestUnsortedContinuousSubarrayTestData(intArrayOf(2, 6, 4, 8, 10, 9, 15), 5),
                ShortestUnsortedContinuousSubarrayTestData(intArrayOf(1, 2, 3, 4), 0),
                ShortestUnsortedContinuousSubarrayTestData(intArrayOf(1), 0),
                ShortestUnsortedContinuousSubarrayTestData(intArrayOf(1, 2, 3, 3, 3), 0),
                ShortestUnsortedContinuousSubarrayTestData(intArrayOf(2, 1), 2),
            )
        tests.forEach { test ->
            val result = shortestUnsortedContinuousSubarray.findUnsortedSubarray(test.nums)
            assertEquals(test.result, result)
        }
    }
}

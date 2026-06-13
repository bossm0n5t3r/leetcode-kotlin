package me.bossm0n5t3r.leetcode.minimumSizeSubarraySum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSizeSubarraySumTest {
    private val sut = MinimumSizeSubarraySum.Solution()

    private data class TestData(val target: Int, val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (target != other.target) return false
            if (!nums.contentEquals(other.nums)) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = target
            result1 = 31 * result1 + nums.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(target = 7, nums = intArrayOf(2, 3, 1, 2, 4, 3), result = 2),
                TestData(target = 4, nums = intArrayOf(1, 4, 4), result = 1),
                TestData(target = 11, nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1), result = 0),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.minSubArrayLen(test.target, test.nums))
        }
    }
}

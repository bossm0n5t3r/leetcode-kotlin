package me.bossm0n5t3r.leetcode.maximumAverageSubarrayI

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAverageSubarrayITest {
    private val sut = MaximumAverageSubarrayI.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: Double) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            return result == other.result
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
        val tests =
            listOf(
                TestData(intArrayOf(1, 12, -5, -6, 50, 3), 4, 12.75),
                TestData(intArrayOf(5), 1, 5.0),
                TestData(intArrayOf(0, 1, 1, 3, 3), 4, 2.0),
            )

        tests.forEach { test -> assertEquals(sut.findMaxAverage(test.nums, test.k), test.result) }
    }
}

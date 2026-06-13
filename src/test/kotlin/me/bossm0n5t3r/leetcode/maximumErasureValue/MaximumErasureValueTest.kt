package me.bossm0n5t3r.leetcode.maximumErasureValue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MaximumErasureValueTest {
    private val maximumErasureValue = MaximumErasureValue.Solution()

    private data class MaximumErasureValueTestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MaximumErasureValueTestData

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
    fun maximumUniqueSubarray() {
        val tests =
            listOf(
                MaximumErasureValueTestData(intArrayOf(4, 2, 4, 5, 6), 17),
                MaximumErasureValueTestData(intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5), 8),
            )
        tests.forEach { test ->
            maximumErasureValue.maximumUniqueSubarray(test.nums).also {
                assertEquals(test.result, it)
            }

            maximumErasureValue.maximumUniqueSubarrayAnotherWay(test.nums).also {
                assertEquals(test.result, it)
            }
        }
    }
}

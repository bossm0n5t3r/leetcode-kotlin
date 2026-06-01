package me.bossm0n5t3r.leetcode.findPivotIndex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPivotIndexTest {
    private val sut = FindPivotIndex.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(nums = intArrayOf(1, 7, 3, 6, 5, 6), result = 3),
                TestData(nums = intArrayOf(1, 2, 3), result = -1),
                TestData(nums = intArrayOf(2, 1, -1), result = 0),
            )

        tests.forEach { test -> assertEquals(sut.pivotIndex(test.nums), test.result) }
    }
}

package me.bossm0n5t3r.leetcode.searchInsertPosition

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchInsertPositionTest {
    private val sut = SearchInsertPosition.Solution()

    private data class TestData(val nums: IntArray, val target: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (target != other.target) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + target
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(nums = intArrayOf(1, 3, 5, 6), target = 5, result = 2),
                TestData(nums = intArrayOf(1, 3, 5, 6), target = 2, result = 1),
                TestData(nums = intArrayOf(1, 3, 5, 6), target = 7, result = 4),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.searchInsert(test.nums, test.target))
        }
    }
}

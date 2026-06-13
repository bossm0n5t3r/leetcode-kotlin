package me.bossm0n5t3r.leetcode.longestSubarrayOf1SAfterDeletingOneElement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestSubarrayOf1SAfterDeletingOneElementTest {
    private val sut = LongestSubarrayOf1SAfterDeletingOneElement.Solution()

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
                TestData(nums = intArrayOf(1, 1, 0, 1), result = 3),
                TestData(nums = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1), result = 5),
                TestData(nums = intArrayOf(1, 1, 1), result = 2),
            )

        tests.forEach { test -> assertEquals(test.result, sut.longestSubarray(test.nums)) }
    }
}

package me.bossm0n5t3r.leetcode.kthLargestElementInAnArray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthLargestElementInAnArrayTest {
    private val sut = KthLargestElementInAnArray.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: Int) {
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
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(nums = intArrayOf(3, 2, 1, 5, 6, 4), k = 2, result = 5),
                TestData(nums = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), k = 4, result = 4),
            )

        tests.forEach { test -> assertEquals(test.result, sut.findKthLargest(test.nums, test.k)) }
    }
}

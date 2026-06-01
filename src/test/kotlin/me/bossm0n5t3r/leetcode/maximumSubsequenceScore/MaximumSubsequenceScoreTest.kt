package me.bossm0n5t3r.leetcode.maximumSubsequenceScore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubsequenceScoreTest {
    private val sut = MaximumSubsequenceScore.Solution()

    private data class TestData(
        val nums1: IntArray,
        val nums2: IntArray,
        val k: Int,
        val result: Long,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums1.contentEquals(other.nums1)) return false
            if (!nums2.contentEquals(other.nums2)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums1.contentHashCode()
            result1 = 31 * result1 + nums2.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 3, 3, 2), intArrayOf(2, 1, 3, 4), 3, 12),
                TestData(intArrayOf(4, 2, 3, 1, 1), intArrayOf(7, 5, 10, 9, 6), 1, 30),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.maxScore(test.nums1, test.nums2, test.k))
        }
    }
}

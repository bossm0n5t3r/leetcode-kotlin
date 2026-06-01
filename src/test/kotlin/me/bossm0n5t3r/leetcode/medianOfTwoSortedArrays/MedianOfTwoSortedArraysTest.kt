package me.bossm0n5t3r.leetcode.medianOfTwoSortedArrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianOfTwoSortedArraysTest {
    private val sut = MedianOfTwoSortedArrays.Solution()

    private data class TestData(val nums1: IntArray, val nums2: IntArray, val result: Double) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums1.contentEquals(other.nums1)) return false
            if (!nums2.contentEquals(other.nums2)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = nums1.contentHashCode()
            result = 31 * result + nums2.contentHashCode()
            return result
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 3), intArrayOf(2), 2.0),
                TestData(intArrayOf(1, 2), intArrayOf(3, 4), 2.5),
                TestData(intArrayOf(1, 3), intArrayOf(2, 7), 2.5),
                TestData(intArrayOf(), intArrayOf(2, 3), 2.5),
                TestData(intArrayOf(1, 2), intArrayOf(-1, 3), 1.5),
            )

        tests.forEach { test ->
            assertEquals(sut.findMedianSortedArrays(test.nums1, test.nums2), test.result)
        }
    }
}

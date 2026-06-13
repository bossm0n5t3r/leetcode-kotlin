package me.bossm0n5t3r.leetcode.findTheDifferenceOfTwoArrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheDifferenceOfTwoArraysTest {
    private val sut = FindTheDifferenceOfTwoArrays.Solution()

    private data class TestData(
        val nums1: IntArray,
        val nums2: IntArray,
        val result: List<List<Int>>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums1.contentEquals(other.nums1)) return false
            if (!nums2.contentEquals(other.nums2)) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = nums1.contentHashCode()
            result1 = 31 * result1 + nums2.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    nums1 = intArrayOf(1, 2, 3),
                    nums2 = intArrayOf(2, 4, 6),
                    result = listOf(listOf(1, 3), listOf(4, 6)),
                ),
                TestData(
                    nums1 = intArrayOf(1, 2, 3, 3),
                    nums2 = intArrayOf(1, 1, 2, 2),
                    result = listOf(listOf(3), emptyList()),
                ),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.findDifference(test.nums1, test.nums2))
        }
    }
}

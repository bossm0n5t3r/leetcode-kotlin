package me.bossm0n5t3r.leetcode.intersectionOfTwoArrays

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IntersectionOfTwoArraysTest {
    private val sut = IntersectionOfTwoArrays.Solution()

    private data class TestData(val nums1: IntArray, val nums2: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums1.contentEquals(other.nums1)) return false
            if (!nums2.contentEquals(other.nums2)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums1.contentHashCode()
            result1 = 31 * result1 + nums2.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2), intArrayOf(2)),
                TestData(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4), intArrayOf(9, 4)),
            )

        tests.forEach { test ->
            assertThat(sut.intersection(test.nums1, test.nums2))
                .containsExactlyInAnyOrder(test.result.toTypedArray())
        }
    }
}

package me.bossm0n5t3r.leetcode.minimumCommonValue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCommonValueTest {
    private val sut = MinimumCommonValue.Solution()

    private data class TestData(val nums1: IntArray, val nums2: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums1.contentEquals(other.nums1)) return false
            if (!nums2.contentEquals(other.nums2)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums1.contentHashCode()
            result1 = 31 * result1 + nums2.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 2, 3), intArrayOf(2, 4), 2),
                TestData(intArrayOf(1, 2, 3, 6), intArrayOf(2, 3, 4, 5), 2),
            )

        tests.forEach { test -> assertEquals(test.result, sut.getCommon(test.nums1, test.nums2)) }
    }
}

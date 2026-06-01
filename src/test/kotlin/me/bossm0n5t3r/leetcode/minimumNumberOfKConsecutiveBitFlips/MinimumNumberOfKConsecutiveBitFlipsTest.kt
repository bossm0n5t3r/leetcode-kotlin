package me.bossm0n5t3r.leetcode.minimumNumberOfKConsecutiveBitFlips

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfKConsecutiveBitFlipsTest {
    private val sut = MinimumNumberOfKConsecutiveBitFlips.Solution()

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
                TestData(intArrayOf(0, 1, 0), 1, 2),
                TestData(intArrayOf(1, 1, 0), 2, -1),
                TestData(intArrayOf(0, 0, 0, 1, 0, 1, 1, 0), 3, 3),
            )

        tests.forEach { test -> assertEquals(test.result, sut.minKBitFlips(test.nums, test.k)) }
    }
}

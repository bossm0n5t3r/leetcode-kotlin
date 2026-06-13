package me.bossm0n5t3r.leetcode.maxNumberOfKSumPairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxNumberOfKSumPairsTest {
    private val sut = MaxNumberOfKSumPairs.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            return result == other.result
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
                TestData(intArrayOf(1, 2, 3, 4), 5, 2),
                TestData(intArrayOf(3, 1, 3, 4, 3), 6, 1),
            )

        tests.forEach { test -> assertEquals(test.result, sut.maxOperations(test.nums, test.k)) }
    }
}

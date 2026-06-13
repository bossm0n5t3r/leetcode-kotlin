package me.bossm0n5t3r.leetcode.maxConsecutiveOnes3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxConsecutiveOnes3Test {
    private val sut = MaxConsecutiveOnes3.Solution()

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
                TestData(nums = intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), k = 2, result = 6),
                TestData(
                    nums = intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1),
                    k = 3,
                    result = 10,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.longestOnes(test.nums, test.k)) }
    }
}

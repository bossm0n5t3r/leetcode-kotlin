package me.bossm0n5t3r.leetcode.squaresOfASortedArray

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SquaresOfASortedArrayTest {
    private val sut = SquaresOfASortedArray.Solution()

    private data class TestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(-4, -1, 0, 3, 10), intArrayOf(0, 1, 9, 16, 100)),
                TestData(intArrayOf(-7, -3, 2, 3, 11), intArrayOf(4, 9, 9, 49, 121)),
            )

        tests.forEach { test -> assertThat(sut.sortedSquares(test.nums)).isEqualTo(test.result) }
    }
}

package me.bossm0n5t3r.leetcode.findFirstAndLastPositionOfElementInSortedArray

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FindFirstAndLastPositionOfElementInSortedArrayTest {
    private val sut = FindFirstAndLastPositionOfElementInSortedArray.Solution()

    private data class FindFirstAndLastPositionOfElementInSortedArrayTestData(
        val nums: IntArray,
        val target: Int,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as FindFirstAndLastPositionOfElementInSortedArrayTestData

            if (!nums.contentEquals(other.nums)) return false
            if (target != other.target) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + target
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun searchRange() {
        val tests =
            listOf(
                FindFirstAndLastPositionOfElementInSortedArrayTestData(
                    intArrayOf(5, 7, 7, 8, 8, 10),
                    8,
                    intArrayOf(3, 4),
                ),
                FindFirstAndLastPositionOfElementInSortedArrayTestData(
                    intArrayOf(5, 7, 7, 8, 8, 10),
                    6,
                    intArrayOf(-1, -1),
                ),
                FindFirstAndLastPositionOfElementInSortedArrayTestData(
                    intArrayOf(),
                    0,
                    intArrayOf(-1, -1),
                ),
            )
        tests.forEach { test ->
            assertThat(sut.searchRange(test.nums, test.target)).isEqualTo(test.result)
        }
    }
}

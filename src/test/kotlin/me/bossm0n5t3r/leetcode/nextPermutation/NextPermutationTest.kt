package me.bossm0n5t3r.leetcode.nextPermutation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NextPermutationTest {
    private val sut = NextPermutation.Solution()

    private data class NextPermutationTestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as NextPermutationTestData

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
    fun nextPermutation() {
        val tests =
            listOf(
                NextPermutationTestData(intArrayOf(1, 2, 3), intArrayOf(1, 3, 2)),
                NextPermutationTestData(intArrayOf(3, 2, 1), intArrayOf(1, 2, 3)),
                NextPermutationTestData(intArrayOf(1, 1, 5), intArrayOf(1, 5, 1)),
            )
        tests.forEach { test ->
            sut.nextPermutation(test.nums)
            assertThat(test.nums).isEqualTo(test.result)
        }
    }
}

package me.bossm0n5t3r.leetcode.largestDivisibleSubset

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LargestDivisibleSubsetTest {
    private val sut = LargestDivisibleSubset.Solution()

    private data class TestData(val nums: IntArray, val result: List<Int>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(1, 2, 3), listOf(1, 2)),
                TestData(intArrayOf(1, 2, 4, 8), listOf(1, 2, 4, 8)),
            )

        tests.forEach { test ->
            assertThat(sut.largestDivisibleSubset(test.nums))
                .containsExactlyInAnyOrderElementsOf(test.result)
        }
    }
}

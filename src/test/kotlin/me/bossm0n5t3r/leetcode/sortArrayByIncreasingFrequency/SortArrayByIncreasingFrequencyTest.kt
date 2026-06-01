package me.bossm0n5t3r.leetcode.sortArrayByIncreasingFrequency

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SortArrayByIncreasingFrequencyTest {
    private val sut = SortArrayByIncreasingFrequency.Solution()

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
                TestData(intArrayOf(1, 1, 2, 2, 2, 3), intArrayOf(3, 1, 1, 2, 2, 2)),
                TestData(intArrayOf(2, 3, 1, 3, 2), intArrayOf(1, 3, 3, 2, 2)),
                TestData(
                    intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1),
                    intArrayOf(5, -1, 4, 4, -6, -6, 1, 1, 1),
                ),
            )

        tests.forEach { test ->
            assertTrue { sut.frequencySort(test.nums).contentEquals(test.result) }
        }
    }
}

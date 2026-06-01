package me.bossm0n5t3r.leetcode.minimumDifferenceBetweenLargestAndSmallestValueInThreeMoves

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMovesTest {
    private val sut = MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
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
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(5, 3, 2, 4), 0),
                TestData(intArrayOf(1, 5, 0, 10, 14), 1),
                TestData(intArrayOf(3, 100, 20), 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.minDifference(test.nums)) }
    }
}

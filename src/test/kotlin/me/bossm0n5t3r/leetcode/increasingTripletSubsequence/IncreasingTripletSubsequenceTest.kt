package me.bossm0n5t3r.leetcode.increasingTripletSubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IncreasingTripletSubsequenceTest {
    private val sut = IncreasingTripletSubsequence.Solution()

    private data class TestData(val nums: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            return result == other.result
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
                TestData(intArrayOf(1, 2, 3, 4, 5), true),
                TestData(intArrayOf(5, 4, 3, 2, 1), false),
                TestData(intArrayOf(2, 1, 5, 0, 4, 6), true),
            )

        tests.forEach { test -> assertEquals(sut.increasingTriplet(test.nums), test.result) }
    }
}
